package ArrayList_task;

/*
Задача 2. Самая длинная строка

1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.+
 */


import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Привет1");
        stringArrayList.add("Привет2");
        stringArrayList.add("Привет3");
        stringArrayList.add("Привет4");
        stringArrayList.add("Привет5");

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(5);
        integerArrayList.add(10);
        integerArrayList.add(15);
        integerArrayList.add(20);
        integerArrayList.add(25);
        integerArrayList.add(30);

        ArrayList<Object> objectList = new ArrayList<>();

        objectList.addAll(stringArrayList);
        objectList.addAll(integerArrayList);

        System.out.println(objectList);

    }
}
