package org.example.Generic;

import java.util.ArrayList;
import java.util.List;

class Fruit { }
class Apple extends Fruit {
    public String type;

    public Apple(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
class Orange extends Fruit {
    public String type;

    public Orange(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}


class Vehicle { }
class Car extends Vehicle { }
class Bike extends Vehicle { }

class Book { }
class Fiction extends Book {
    String nameBook;

    public Fiction(String nameBook) {
        this.nameBook = nameBook;
    }

    @Override
    public String toString() {
        return nameBook;
    }
}
class NonFiction extends Book {
    String nameBook;

    public NonFiction(String nameBook) {
        this.nameBook = nameBook;
    }

    @Override
    public String toString() {
        return nameBook;
    }
}


public class Generics {
    public static void main(String[] args) {

        List<Fiction> fictions = new ArrayList<>();
        fictions.add(new Fiction("Книга о любви"));

        List<NonFiction> nonFictions = new ArrayList<>();
        nonFictions.add(new NonFiction("Книга о книге"));

        List<Book> books = new ArrayList<>();
        // типо добавил тут могло быть лучше
        books.add(fictions.get(0));
        books.add(nonFictions.get(0));

        readAllBook(books);
    }
    public static String getFirstFruit(List<? extends Fruit> fruits){
        return fruits.get(0).toString();
    }
    public static String getFirstVehicle(List<? extends Vehicle> vehicles){
        return vehicles.get(0).toString();
    }
    public static void readAllBook(List<? extends Book> books){
        for (Book b: books) {
            System.out.println(b);
        }
    }
}
