package animalsforhomework.main;
import animalsforhomework.enums.Command;
import animalsforhomework.models.*;

import java.util.ArrayList;
import java.util.Scanner;


public class AnimalApp {
    private static final ArrayList<Animal> animals = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);





    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите команду (add/list/exit):");
            String input = scanner.nextLine().trim();
            Command command = Command.fromString(input);

            if (command == null) {
                System.out.println("Неверная команда! Попробуйте еще раз.");
                continue;
            }

            switch (command) {
                case ADD:
                    addAnimal();
                    break;
                case LIST:
                    listAnimals();
                    break;
                case EXIT:
                    System.out.println("Выход из программы.");
                    return;
            }
        }
    }

    private static void addAnimal() {
        Animal animal = null;

        // Цикл для ввода типа животного
        while (animal == null) {
            System.out.println("Какое животное вы хотите добавить (cat/dog/duck)?");
            String animalType = scanner.nextLine().trim();

            System.out.println("Введите имя:");
            String name = scanner.nextLine().trim();

            // Ввод и валидация возраста
            int age = 0;
            while (true) {
                System.out.println("Введите возраст:");
                try {
                    age = Integer.parseInt(scanner.nextLine().trim());
                    if (age <= 0) {
                        System.out.println("Возраст должен быть положительным числом. Попробуйте снова.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат возраста. Введите целое положительное число.");
                }
            }

            // Ввод и валидация веса
            double weight = 0.0;
            while (true) {
                System.out.println("Введите вес:");
                try {
                    weight = Double.parseDouble(scanner.nextLine().trim());
                    if (weight <= 0) {
                        System.out.println("Вес должен быть положительным числом. Попробуйте снова.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат веса. Введите положительное число.");
                }
            }

            System.out.println("Введите цвет:");
            String color = scanner.nextLine().trim();

            try {
                // Попытка создать животное через фабрику
                animal = AnimalFactory.createAnimal(animalType, name, age, weight, color);
            } catch (IllegalArgumentException e) {
                // Если тип животного неверный, вывести сообщение и запросить ввод заново
                System.out.println(e.getMessage());
                System.out.println("Попробуйте снова.");
            }
        }

        // Если животное успешно создано, добавляем в список и вызываем метод say()
        animals.add(animal);
        animal.say();
    }

    private static void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Нет животных в списке.");
            return;
        }

        System.out.println("Список животных:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
