package org.example.Collections;
import java.util.*;


class LengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

public class ComparatorPractice {
    public static void main(String[] args) {
        // anonymousClass();
        // lambdaExpression();
        // classComparator();
        //anonymousClassAgePerson();
    }

    // Реализация через анонимный класс
    public static void anonymousClass(){
        List<String> stringList = Arrays.asList("Привет","Как дела?", "Что делаешь, как жизнь?", "Абуба", "Попа");

        // Анонимный класс, имплементируем интерфейс без создания класса
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println(stringList);
    }

    // Реализация через лямбду выражение
    public static void lambdaExpression(){
        List<String> stringList = Arrays.asList(
                "Привет",
                "Как дела?",
                "Что делаешь,",
                "как жизнь?",
                "Абуба",
                "Попа",
                "123",
                "4567",
                "78901234567890",
                "qwertyuiopasdfghjklzxcvbnm",
                "1234567890");

        stringList.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(stringList);

    }

    // Реализация через Класс реализующий Comparator
    public static void classComparator(){
        List<String> stringList = Arrays.asList("Привет","Как дела?", "Что делаешь, как жизнь?", "Абуба", "Попа");
        Collections.sort(stringList,new LengthComparator());
        System.out.println(stringList);
    }

    // Реализация через анонимный класс, с использованием Person
    public static void anonymousClassAgePerson(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Vlad",23,6));
        personList.add(new Person("Sergey",25,7));
        personList.add(new Person("Alex",18,4));
        personList.add(new Person("Nikita",20,5));
        personList.add(new Person("Dima",22,2));

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        System.out.println(personList);
    }
}
