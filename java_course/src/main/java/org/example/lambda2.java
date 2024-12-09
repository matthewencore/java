package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Player{
    String name;
    int hp;

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class HeavyObject{
    String name;

    public HeavyObject(String name) {
        this.name = name;
    }

    public HeavyObject() {}

    //...
    static HeavyObject create(){
        // Создаём новый объект тяжелого объекта.
        return new HeavyObject();
    }
}

class SupplierClass{

    // Пример 1: Простое использование Supplier для получения строки
    Supplier<String> task1(){
        Supplier<String> supplier = () -> "Строка";
        return supplier;
    }

    // Пример 2: Ленивое создание объекта
    Supplier<HeavyObject> task2(){
        Supplier<HeavyObject> heavyObjectSupplier = HeavyObject::create;
        return heavyObjectSupplier;
    }

    // Пример 3: Использование Supplier для получения случайного числа
    Supplier<Integer> task3(){
        Supplier<Integer> supplier = () -> new Random().nextInt(1,100);
        return supplier;
    }

    // Пример 4: Использование Supplier для ленивой инициализации коллекции
    Supplier<List<Integer>> task4(){
        Supplier<List<Integer>> supplier = () -> {
            return new ArrayList<>();
        };
        return supplier;
    }

    // Пример 5: Генерация UUID (уникального идентификатора)
    Supplier<String> task5(){
        Supplier<String> stringSupplier = () -> UUID.randomUUID().toString();
        return stringSupplier;
    }

    // Пример 6: Создание текста с использованием Supplier
    Supplier<StringBuilder> supplier = () -> {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Привет ");
        stringBuilder.append("Как дела? ");
        stringBuilder.append("Что ты делаешь? ");
        return stringBuilder;
    };
}

class PredicateClass{
    // Пример 1: Проверка на четное число
    Predicate<Integer> task1 = (num) -> {
        return num % 2 == 0;
    };

    // Пример 2: Фильтрация
    Predicate<Player> task2 = obj -> obj.name.startsWith("А");
    List<Player> listPlayer(List<Player> p){
         List<Player> list = p.stream().filter(task2).toList();
         return list;
    }

    // Комбинирование Predicate
    Predicate<Player> task3 = obj -> obj.name.startsWith("К");
    List<Player> combinPlayer(List<Player> p){
       return p.stream().filter(Predicate.not(task2.or(task3))).collect(Collectors.toList());
    }
    Predicate<Player> hp0 = obj -> obj.hp == 0;
    List<Player> filterPlayer(List<Player> p) {
        return p.stream().filter(Predicate.not(hp0)).collect(Collectors.toList());
    }

}

public class lambda2 {
    public static void main(String[] args) {
        PredicateClass pc =  new PredicateClass();
        List<Player> p = List.of(
                new Player("Кирилл",0),
                new Player("Андрей",0),
                new Player("Николай",0),
                new Player("Евгений",0),
                new Player("Аджу",1),
                new Player("Катетсу",0),
                new Player("Картер",0)
        );

        List<Player> pList = pc.filterPlayer(p);
        System.out.println(pList);


    }
}
