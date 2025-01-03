package animalsforhomework.models;

public class AnimalFactory {
    public static Animal createAnimal(String animalType, String name, int age, double weight, String color) {
        switch (animalType.toLowerCase()) {
            case "cat":
                return new Cat(name, age, weight, color);
            case "dog":
                return new Dog(name, age, weight, color);
            case "duck":
                return new Duck(name, age, weight, color);
            default:
                throw new IllegalArgumentException("Неизвестный тип животного: " + animalType);
        }
    }
}