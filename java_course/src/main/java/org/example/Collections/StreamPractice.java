package org.example.Collections;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class StreamPractice {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Vlad",23,2));
        personList.add(new Person("Andrew",21,4));
        personList.add(new Person("Kirill",20,1));
        personList.add(new Person("Lebovsku",27,7));
        personList.add(new Person("Maria",11,8));
        personList.add(new Person("Liza",14,9));

        //personList.sort((o1, o2) -> Integer.compare(o1.getAge(),o2.getAge()));
        personList.stream().filter(p -> {
            return p.getAge() >= 18;
        }).sorted((o1, o2) -> Integer.compare(o1.getAge(),o2.getAge())).forEach(person -> out.println(person));

    }
}
