package org.example;

class Animal {
    private static int count = 0;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }
}
class Dog extends Animal {
    private static int dogCount = 0;

    public Dog() {
        super();
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать больше 500 м.");
        }
    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть больше 10 м.");
        }
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;

    public Cat() {
        super();
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать больше 200 м.");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(FoodBowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            bowl.decreaseFood(1);
            isFull = true;
            System.out.println("Кот покушал и теперь сыт.");
        } else {
            System.out.println("В миске недостаточно еды, кот не покушает.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

class FoodBowl {
    private int foodAmount;

    public FoodBowl(int initialFood) {
        this.foodAmount = initialFood >= 0 ? initialFood : 0;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
        } else {
            System.out.println("Недостаточно еды в миске.");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску.");
        }
    }
}
class Execution {
    public static void execution() {

        Cat[] cats = new Cat[2];
        cats[0] = new Cat();
        cats[1] = new Cat();

        FoodBowl foodBowl = new FoodBowl(4);

        for (Cat cat : cats) {
            cat.eat(foodBowl);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сыт: " + cats[i].isFull());
        }

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.run(500);
        dog1.swim(11);
        dog2.run(501);
        dog2.swim(10);

        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}

interface Shape {

    String getFillColor();

    String getBorderColor();

    double area();

    default double perimeter() {
        return 0;
    }

    default void printInfo() {
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-----------------------------");
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }
}

class Execute {
    public static void execute() {
        Shape circle = new Circle(19, "Белый", "Зелёный");
        Shape rectangle = new Rectangle(4, 3, "Тиффани", "Чёрный");
        Shape triangle = new Triangle(8, 8, 15, "Голубой", "Синий");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Треугольник:");
        triangle.printInfo();
    }
}