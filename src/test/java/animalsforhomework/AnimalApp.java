package animalsforhomework;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalApp {
    private static final ArrayList<Animal> animals = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public enum Command {
        ADD, LIST, EXIT;

        public static Command fromString(String command) {
            try {
                return Command.valueOf(command.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

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
        System.out.println("Какое животное вы хотите добавить (cat/dog/duck)?");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Введите имя:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Введите вес:");
        double weight = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Введите цвет:");
        String color = scanner.nextLine().trim();

        Animal animal = null;
        switch (animalType) {
            case "cat":
                animal = new Cat(name, age, weight, color);
                break;
            case "dog":
                animal = new Dog(name, age, weight, color);
                break;
            case "duck":
                animal = new Duck(name, age, weight, color);
                break;
            default:
                System.out.println("Неизвестный тип животного!");
                return;
        }

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
