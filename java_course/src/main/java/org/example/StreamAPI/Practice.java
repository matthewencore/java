package org.example.StreamAPI;

import org.example.Collections.StreamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CreateStream {

    // 1. Классический: Создание стрима из коллекции
    static Stream<String> method1(){
        Collection<String> stringCollection = Arrays.asList("a1","a2","a3");
        System.out.println(stringCollection.getClass().getName());

        return stringCollection.stream();
    }

    // 2. Создание стрима из значений
    static Stream<String> method2(){
        return Stream.of("a1","a2","a3");
    }

    // 3. Создание стрима из cписка
    static void method3(){
        List<String> list = Arrays.asList("5","9","10","11","25","6","8");
        list.stream();
    }

    // 4. Создание стрима из строки
    static void method4(){
        IntStream streamFromString = "123".chars();
    }
}

class PracticeTask{
    void task1() {
        List<String> stringList = Arrays.asList(
                "1",
                "2",
                "3",
                "4",
                "5"
        );

        boolean isMatch = stringList.stream().anyMatch((arg) -> {
            return arg.equals("1");
        });

        System.out.println(isMatch);
    }
    void task2(){
        List<Integer> integers = Arrays.asList(1,9,11,58,25,17,16,25,99,478);
        List<Integer> a = integers.stream()
                .skip(2)
                .limit(5)
                .toList();

        a.stream().sorted((o1,o2) -> Integer.compare(o1,o2)).forEach(System.out::println);
    }

}

enum Sex{
    M("Мужчина"),
    W("Женщина");

    String choise;

    Sex(String choise) {
        this.choise = choise;
    }

    public String getChoise() {
        return choise;
    }
}

class People {
    String name;
    int age;
    Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public People() {
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}


public class Practice {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "a1","a1", "a3", "a3", "a3","a1","a2", "a3", "a4");
        List<Integer> integer = Arrays.asList(5,77,11,6,9,5,44);
        List<People> people = Arrays.asList(
                new People("Кирилл",21,Sex.M),
                new People("Андрей",29,Sex.M),
                new People("Евгений",19,Sex.M),
                new People("Петр",17,Sex.M),
                new People("Екатирина",19,Sex.W),
                new People("Ольга",21,Sex.W),
                new People("Елена",16,Sex.W),
                new People("Татьяна",25,Sex.M),
                new People("Лика",23,Sex.M)
        );

        List<StringBuilder> stringBuilders = Stream.generate(StringBuilder::new).limit(10).toList();
        List<StringBuilder> sb = stringBuilders.stream().peek(x -> x.append(new Random().nextInt(0,10000)).append("_new")).toList();
        sb.forEach(System.out::println);
        



//        List<StringBuilder> stringBuilders = Stream.generate(StringBuilder::new).limit(10).toList();
//        stringBuilders.forEach(x -> x.append(new Random().nextInt(0, 100)).append("_new"));
//        stringBuilders.forEach(System.out::println);


    }
}
