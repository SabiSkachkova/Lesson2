package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isBooked;

    public Product(String name, LocalDate productionDate, String manufacturer, String country, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isBooked ? "Забронировано" : "Свободно"));
    }

    public static void product() {
        Product[] productsArray = new Product[5];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        productsArray[0] = new Product("Menron",
                LocalDate.parse("20.05.2025", formatter),
                "Menron", "China", 25000, true);

        productsArray[1] = new Product("Tefal Optitouch HB833132",
                LocalDate.parse("20.05.2025", formatter),
                "Tefal", "Japan", 47593, false);

        productsArray[2] = new Product("Nintendo Switch OLED",
                LocalDate.parse("10.04.2025", formatter),
                "Nintendo", "China", 22999, true);

        productsArray[3] = new Product("Lettfort",
                LocalDate.parse("10.05.2025", formatter),
                "Lettfort", "South Korea", 9358, false);

        productsArray[4] = new Product("Sonic Toothbrush",
                LocalDate.parse("05.03.2025", formatter),
                "Sonic", "China", 23686, true);

        for (Product product : productsArray) {
            product.printInfo();
            System.out.println("---------------------------");
        }
    }

    public static class Park {
        private String name;
        private Attraction[] attractions;
        private int attractionCount;

        public Park(String name, int maxAttractions) {
            this.name = name;
            this.attractions = new Attraction[maxAttractions];
            this.attractionCount = 0;
        }

        public void addAttraction(String name, String workingHours, double price) {
            if (attractionCount < attractions.length) {
                attractions[attractionCount++] = new Attraction(name, workingHours, price);
            } else {
                System.out.println("Достигнуто максимальное количество аттракционов.");
            }
        }

        public void displayAttractions() {
            System.out.println("Аттракционы в парке " + name + ":");
            for (int i = 0; i < attractionCount; i++) {
                System.out.println(attractions[i]);
            }
        }

        private class Attraction {
            private String name;
            private String workingHours;
            private double price;

            public Attraction(String name, String workingHours, double price) {
                this.name = name;
                this.workingHours = workingHours;
                this.price = price;
            }

            public String toString() {
                return "Аттракцион: " + name + ", Время работы: " + workingHours + ", Стоимость: " + price + " руб.";
            }
        }

        public static void park() {
                Park park = new Park("Диво Остров",4);

                park.addAttraction("Вокруг света", "11:00 - 21:00", 800);
                park.addAttraction("Картинг", "11:00 - 21:00", 3000);
                park.addAttraction("Катамараны", "12:00 - 29:00", 550);

                park.displayAttractions();
        }
    }
}






