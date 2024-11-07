package org.example.OOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Animal{ // базовый класс
    protected String name;
    protected String age;

    public Animal() {}

    public Animal(String age, String name) {
        this.age = age;
        this.name = name;
    }

    void makeSound(){
        System.out.println("| Базовый звук неопределенного животного");
    }
}
class Dog extends Animal {
    private String typeDog;

    public Dog() {}
    public Dog(String age, String name,String typeDog) {
        super(age, name);
        this.typeDog = typeDog;
    }

    @Override
    void makeSound() {
        System.out.printf("| Звук лая собаки %s",typeDog);
    }
}
class Cat extends Animal {
    void ЛакатьМолоко(){
        System.out.printf("%s / %s лакает молоко",super.name, super.age);
    }

    public Cat() {super();}

    public Cat(String age, String name) {super(age, name);}

    @Override
    void makeSound() {
        System.out.println(String.format("%s сделал мяу",super.name));
    }
}

class Print{
    void print(String s){
        System.out.println(s);
    }
    void print(int n){
        System.out.println(n);
    }
    void print(double d){
        System.out.println(d);
    }
}

class Person{
    String name;
    int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    void about(){
        System.out.printf("\n| Персона: %s возраст: %s",this.name, this.age);
    }
}
class Student extends Person{
    String course;

    double rating;
    Map<String,Double> grades = new HashMap<>();

    public Student(String name, int age, double height, String course) {
        super(name, age, height);
        this.course = course;
    }

    @Override
    void about() {
        System.out.printf("\n| Студент %s курса %s возраст %s",this.course, super.name, super.age);
    }
    public void myRate(){
        System.out.printf("\n| rate: %s",rating);
    }

    public void grades(){
        if (grades.isEmpty()){
            System.out.println("\n| Студент не имеет оценок");
            return;
        }
        System.out.println("\n=======Оценки студента=======");
        for (Map.Entry<String,Double> item : grades.entrySet()) {
            System.out.printf("| Предмет: %s Оценка: %s\n",item.getKey(),item.getValue());
        }
        System.out.println("=============================");
    }
}
class HeadStudent extends Person{
    public HeadStudent(String name, int age, double height) {
        super(name, age, height);
    }

    @Override
    void about() {
        System.out.printf("\n| Преподаватель %s возраст %s", super.name, super.age);
    }

    void rateStudent(Student student){
        student.rating +=0.1;
    }
    void rateStudent(Student student,double value){
        if (value < 0 || value > 5 ) {
            System.out.println("\n| К сожалению рейтинг не может быть таким высоким.");
        }
        student.rating = value;
    }
    void giveGrade(Student student,String item,double grade){
        student.grades.put(item,grade);
    }

}

class Cat2{
    String name;
    String age;
    String owner;

    public Cat2(String age, String owner, String name) {
        this.age = age;
        this.owner = owner;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("The cat \"%s\" is already \"%s\". Her master \"%s\" takes care of her.",
                this.name,
                this.age,
                this.owner
        );
    }

    public String getName() {
        return name;
    }

    public Cat2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Cat2 setAge(String age) {
        this.age = age;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public Cat2 setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}

class StarSystem{
    private String starName;
    private int quantityOfPlanets;
    private int age;

    public StarSystem(String starName, int quantityOfPlanets, int age) {
        this.starName = starName;
        this.quantityOfPlanets = quantityOfPlanets;
        this.age = age;
    }

    public String getStarName() {
        return starName;
    }

    public StarSystem setStarName(String starName) {
        this.starName = starName;
        return this;
    }

    public int getQuantityOfPlanets() {
        return quantityOfPlanets;
    }

    public StarSystem setQuantityOfPlanets(int quantityOfPlanets) {
        this.quantityOfPlanets = quantityOfPlanets;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StarSystem setAge(int age) {
        this.age = age;
        return this;
    }

    public String getInfo(){
        return String.format("{%s %s %s}",starName, quantityOfPlanets, age);
    }
}
class SunSystem extends  StarSystem{
    private long population;

    public SunSystem(String starName, int quantityOfPlanets, int age, long population) {
        super(starName, quantityOfPlanets, age);
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }

    public SunSystem setPopulation(long population) {
        this.population = population;
        return this;
    }


    @Override
    public String getInfo() {
        return "This is the most densely populated star system in the universe(probably).\n";
    }
}

class Bird {
    String typeBird;
    List<String> continents = new ArrayList<>();
    int population;


    public Bird(String typeBird, List<String> continents, int population) {
        this.typeBird = typeBird;
        this.continents = continents;
        this.population = population;
    }
}
class Pigeon extends Bird {
    int hunger;

    public Pigeon(String typeBird, List<String> continents, int population, int hunger) {
        super(typeBird, continents, population);
        this.hunger = hunger;
    }

    public void askForSeeds(){
        if (hunger < 0){
            return;
        }
        hunger -= 7;
    }

    public void sleep(){
        hunger += 3;
    }

    public int getHunger() {
        return hunger;
    }

}

class Account{
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    void withdraw(int n){
        if (n > this.balance){
            System.out.println("Снято " + this.balance);
            balance = 0;
        } else {
            balance -= n;
        }

    }
    void put (int n){
        if (n < 0){
            return;
        }
        balance += n;
    }
    int checkBalance(){
        return this.balance;
    }
}
class ChekingAccount extends Account{

    public ChekingAccount(int balance) {
        super(balance);
    }

    @Override
    void put(int n) {
        balance += n;
    }

}
class Deposit extends Account {
    private int period;
    private double percent;

    public Deposit(int balance, int period, double percent) {
        super(balance);
        this.period = period;
        this.percent = percent;
    }

}

public class Practice {
    public static void main(String[] args) {

    }

}
