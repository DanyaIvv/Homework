package animalsforhomework;

public class Animal {
    private String name;
    private Integer age;
    private double weight;
    private String color;


    public Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void say () {
        System.out.println("Я говорю");
    }
    void go () {
        System.out.println("Я иду");
    }
    void drink () {
        System.out.println("Я пью");
    }
    void eat () {
        System.out.println("Я ем");
    }
    @Override
        public String toString() {
            String ageSuffix;
            if (age % 10 == 1 && age % 100 != 11) {
                ageSuffix = "год";
            } else if ((age % 10 >= 2 && age % 10 <= 4) && (age % 100 < 10 || age % 100 >= 20)) {
                ageSuffix = "года";
            } else {
                ageSuffix = "лет";
            }

            return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %.1f кг, мой цвет - %s",
                    name, age, ageSuffix, weight, color);
        }
    public static void main(String[] args) {
        Animal animal1 = new Animal("Бобик", 5, 15, "черный");
        Animal animal2 = new Animal("Барсик", 1, 4.5, "белый");
        Animal animal3 = new Animal("Мурка", 2, 6, "серый");

        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);

        animal1.say();
        animal2.go();
        animal3.drink();
    }
    }

