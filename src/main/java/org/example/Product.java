package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
}






