package org.example;

import java.util.ArrayList;
import java.util.List;

 public class Park {
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
         Park park = new Park("Диво Остров", 4);

         park.addAttraction("Вокруг света", "11:00 - 21:00", 800);
         park.addAttraction("Картинг", "11:00 - 21:00", 3000);
         park.addAttraction("Катамараны", "12:00 - 29:00", 550);

         park.displayAttractions();
     }
 }