package org.example;
import java.util.*;


    class Student {
        private String name;
        private String group;
        private int course;
        private List<Integer> grades;

        public Student(String name, String group, int course, List<Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = new ArrayList<>(grades);
        }

        public String getName() {
            return name;
        }

        public int getCourse() {
            return course;
        }

        public void nextCourse() {
            this.course++;
        }

        public double averageGrade() {
            if (grades.isEmpty()) return 0;
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }

        public String toString() {
            return name + " (группа: " + group + ", курс: " + course + ", средний балл: " + averageGrade() + ")";
        }
    }

     class StudentManager {

        public static void removeLowGrades(Set<Student> students) {
            students.removeIf(student -> student.averageGrade() < 3);
        }

        public static void promoteStudents(Set<Student> students) {
            for (Student student : students) {
                if (student.averageGrade() >= 3) {
                    student.nextCourse();
                }
            }
        }

        public static void printStudents(Set<Student> students, int course) {
            System.out.println("Студенты курса " + course + ":");
            for (Student student : students) {
                if (student.getCourse() == course) {
                    System.out.println(student.getName());
                }
            }
        }

        public static void execute() {
            Set<Student> students = new HashSet<>();

            students.add(new Student("Обухова Мария", "Группа1", 1, Arrays.asList(5, 5, 4)));
            students.add(new Student("Артимович Анжелика", "Группа2", 2, Arrays.asList(2, 2, 3)));
            students.add(new Student("Тимошина Карина", "Группа1", 1, Arrays.asList(3, 3, 3)));
            students.add(new Student("Попоян Александр", "Группа3", 3, Arrays.asList(2, 3, 3)));

            System.out.println("Все студенты:");
            students.forEach(System.out::println);

            removeLowGrades(students);
            System.out.println("\nПосле удаления студентов со средним баллом < 3:");
            students.forEach(System.out::println);

            promoteStudents(students);
            System.out.println("\nПосле перевода на следующий курс:");
            students.forEach(System.out::println);

            printStudents(students, 2);
        }
    }

    class PhoneBook {
        private Map<String, List<String>> phoneBook = new HashMap<>();

        public void add(String lastName, String phoneNumber) {
            phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
        }

        public List<String> get(String lastName) {
            return phoneBook.getOrDefault(lastName, Collections.emptyList());
        }

        public static void execution() {
            PhoneBook pb = new PhoneBook();

            pb.add("Скачкова", "+7-999-465-95-06");
            pb.add("Скачкова", "+7-999-999-99-99");
            pb.add("Попоян", "+7-921-111-11-11");

            System.out.println("Телефоны Скачковой: " + pb.get("Скачкова"));
            System.out.println("Телефоны Попояна: " + pb.get("Попоян"));
        }
    }




