package org.example.Collections;

import java.util.*;

//Класс Person для тестов
class Person{
    int id;
    String name;
    int age;

    public Person() {}

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }
}



class Test<T> {
    public T t;

    public Test(T t) {
        this.t = t;
    }

    void genericMethod(){
        if (t instanceof String) {
            System.out.println("Это строка");
        }
    }

}

class Node<E> {
    E item; // ссылка на хранимый объект
    Node<E> next; // ссылка на следующий объект типа Node
    Node<E> prev; // ссылка на предыдущий объект типа Node

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

/*
    Задача 3: Стек с дженериками
    Условие: Реализуй класс GenericStack<T>, который представляет собой стек
    с операциями push(), pop() и peek().
    Класс должен поддерживать обобщенный тип и работать с любыми объектами.
*/
class StackGenerics<T>{
    List<T> stack = new LinkedList<>();

    void push(T item){
        stack.add(item);
    }

    T peek(){
        if (!stack.isEmpty()) {
            return stack.getLast();
        }
        return null;
    }

    T pop(){
        if (!stack.isEmpty()) {
            return stack.removeLast();
        }
        return null;
    }

}


/*
Задача 4: Метод с контравариантностью
Условие: Напиши метод, который принимает список типа List<? super Integer> и добавляет в него целое число.
Метод должен быть универсальным и работать с любыми родительскими типами для Integer.
 */
class Contravariantnost<T>{
    List<? super Integer> addInteger(List<? super Integer> list,int integer){
        list.add(integer);
        return list;
    }
}

/*
Задача 5: Обобщённый метод для сравнения двух объектов
Условие: Напиши метод, который принимает два объекта типа T и сравнивает их.
Если объекты равны, метод должен возвращать true, иначе — false. Метод должен работать с любыми типами.
*/
class EqualsClass<T>{
    public boolean СравнениеДвухОбъектов(T object, T object2){
        if (object.equals(object2)){
            return true;
        }
        return false;
    }
}

/*
Задача 6: Сортировка списка с дженериками
Условие: Напиши метод, который принимает List<T> и сортирует его в порядке возрастания.
Тебе нужно будет реализовать сортировку с помощью Comparator.
*/
class SortMethod<T>{
     public List<T> list(List<T> list,Comparator<T> comparator) {
        list.sort(comparator);
        return list;
    }
}

class CompareId implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.id,o2.id);
    }
}
class CompareAge implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age,p2.age);
    }
}


public class Generic {
    // Простой дженерик в методе
    public static <T> void generic1(List<T> list){
        for (T el: list) {
            System.out.println(el.getClass().getName());
        }
    }
    // Задача 2
    public static Number generic2(List<? extends Number> nums){
        double summa = 0;
        for (Number n: nums) {
            System.out.println(n.getClass().getName());
            summa += n.doubleValue();
        }
        return summa;
    }

    public static <T> void generic3(){

    }

    public static void main(String[] args) {
        SortMethod sortMethod = new SortMethod();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Kirill",21,0));
        personList.add(new Person("Andrew",25,1));
        personList.add(new Person("Mykola",19,2));
        personList.add(new Person("Liza",17,3));

        List<Person> sortedPeople = sortMethod.list(personList, new CompareId());

        for (Person p : sortedPeople) {
            //System.out.println(p.name + " " + p.age);
        }

        sortList();
   }
   //Использование Compare
   public static void sortList(){
        List<String> stringList = Arrays.asList("Арбуз", "Помидор", "Нектарин", "Зелень");
        stringList.sort((o1, o2) -> Integer.compare(o1.length(),o2.length()));
        System.out.println(stringList);
   }

    public static void vargs(String... args){
        for (String item: args) {
            System.out.println(item);
        }
    }

}
