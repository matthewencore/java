package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

enum TypeCats{
    FOREST("Лесная"),
    MANUL("Манул"),
    TIGR("Тигр"),
    SFINKC("Сфинкс");

    private String choise;


    TypeCats(String choise) {
        this.choise = choise;
    }

    public String getChoise() {
        return choise;
    }
}
enum TypeDogs{
    RETRIVER("Ретривер"),
    DEUTCHLANDDOG("Овчарка"),
    HASKI("Хаски");

    String choice;

    TypeDogs(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}

abstract class Animals{
    String name;
    double height;
    double weight;
    int age;
    private boolean vegetarian;
    private String eats;

    public Animals(int age, String name, double weight, double height, boolean vegetarian, String eats) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.vegetarian = vegetarian;
        this.eats = eats;
    }


    abstract public void sound();
    abstract public void getEat();

}

class Cats extends Animals {
    TypeCats typeCats;

    public Cats(int age, String name, double weight, double height, boolean vegetarian, String eats, TypeCats typeCats) {
        super(age, name, weight, height, vegetarian, eats);
        this.typeCats = typeCats;
    }


    @Override
    public String toString() {
        return "Cats{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void sound() {
        System.out.println(name+": Мяу-мяу!");
    }

    @Override
    public void getEat() {
        System.out.println(name+": *Спокойно чавкает хрючево*");
    }
}

class Dogs extends Animals{
    TypeDogs typeDogs;

    public Dogs(int age, String name, double weight, double height, boolean vegetarian, String eats, TypeDogs typeDogs) {
        super(age, name, weight, height, vegetarian, eats);
        this.typeDogs = typeDogs;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void sound() {
        System.out.println(name+": Гав-гав!");
    }

    @Override
    public void getEat() {
        System.out.println(name+": *Агрессивно чавкает хрючево*");
    }
}

class ZooPark {
   public List<? extends Animals> animals;

    public ZooPark(List<? extends Animals> animals) {
        this.animals = animals;
    }

    void printZoo(){
        for (Animals animal: animals) {
            System.out.printf(
                    """
                    ================================
                    -> Карточка животного %s
                    -> Возраст: %s | Вес: %s | Рост: %s
                    ================================
                    """,animal.name, animal.age, animal.weight, animal.height);
        }
    }
    void printEat(){
        for (Animals animals: animals){
            animals.getEat();
        }
    }

}



class Zoo {
    public static void main(String[] args) {
        List<Animals> animals = new ArrayList<>();

        animals.add(new Cats(2,"Мурзик",5,0.3,false,"Рыба",TypeCats.FOREST));
        animals.add(new Dogs(5,"Шарик",15,0.7,false,"Мясо",TypeDogs.RETRIVER));
        animals.add(new Cats(1,"Пушок",3,0.2,false,"Мыши",TypeCats.MANUL));
        animals.add(new Dogs(3,"Бобик",10,0.5,false,"Кости",TypeDogs.DEUTCHLANDDOG));

        ZooPark zooPark = new ZooPark(animals);
        zooPark.printEat();

    }



}
