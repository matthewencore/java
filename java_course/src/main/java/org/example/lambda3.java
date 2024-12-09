package org.example;
import java.util.*;
import java.util.function.*;

class Item{
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}

public class lambda3 {
    static Function<String,String> f1 = (str) -> str;
    static Function<String,String> f2 = (str) -> str;

    public static void main(String[] args) {

    }
}
