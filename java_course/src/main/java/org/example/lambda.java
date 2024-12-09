package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;
import java.util.Random;
import java.util.random.RandomGenerator;

import static java.lang.System.out;

// Интерфейс состоит из наборов заголовков метода.
// Интерфейс является связующем звеном.
interface ElecricityConsumer{
    void electricityOn(Object sender);
}

class Switcher{
    // Можем сделать поле типа интерфейса.
    // Это поле которое может содержать ссылку на объект любого класса
    // Реализующий данный интерфейс, в данном случае ElicricityConsumer.
     private List<ElecricityConsumer> listeners =
            new ArrayList<>();

     // Добавить подписку на событие
     public void addElectricityListener(ElecricityConsumer listener){
         if (listeners.contains(listener)){
             out.println("Подписка на событие не возможна");
             return;
         }

         listeners.add(listener);
         out.printf("Подписка на событие %s добавлена",listener.getClass().getName());
     }

    // Удалить подписку на событие
    public void removeElectricityListener(ElecricityConsumer listener){
        listeners.remove(listener);
    }

    public void switchOn(){
        out.println("Выключатель включен!");
        for (ElecricityConsumer c: listeners){
            c.electricityOn(this);
        }
    }
    //     public void switchOn(){
    //        // Проверяем, а есть ли у нас ссылка на реальный объект?
    //        if (elecricityConsumer != null){
    //            // Данная ссылка может указывать только на объекты класса реализующие данный интерфейс.
    //            elecricityConsumer.electricityOn();
    //        }
    //        System.out.println("Выключатель включен!");
    //    }
}

class Lamp implements ElecricityConsumer{
    public void lightOn(){
        out.println("Лампа зажглась!");
    }

    @Override
    public void electricityOn(Object sender) {
        lightOn();
    }
}

class Radio implements ElecricityConsumer{
    public void radioOn(){
        out.println("Радио включено!");
    }

    @Override
    public void electricityOn(Object sender) {
        radioOn();
    }
}

class PersonLambda {
    String name;
    int age;
    int id;

    public PersonLambda(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + id;
    }
}
//создай класс Человек с параметрами


public class lambda {

    static Function<String,String> function = (str) -> str;

    public static void consumer(){

        List<PersonLambda> list = new ArrayList<>();
        list.add(new PersonLambda("Vlad",23,4));
        list.add(new PersonLambda("Nikita",33,7));
        list.add(new PersonLambda("Matthew",19,25));
//
//        Consumer<PersonLambda> personLambdaConsumer = personLambda -> out.println(personLambda);
//        list.forEach(personLambdaConsumer);


        Consumer<PersonLambda> consumer = (person) -> {
            person.age += 5;
            out.println(person.getAge()); };
        list.forEach(consumer);



       // Consumer<String> logger = message -> System.out.println("Log: " + message);
        // logger.accept("Привет");
    }

    public static void functionLambda(){
        out.println(function.apply("Привет"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        BiFunction<String,DateTimeFormatter, LocalDate> f = (String template, DateTimeFormatter dtf) -> {
//            return LocalDate.parse(template,dtf);
//        };
        // Function<String, Integer> stringFunction = (s) -> s.length();
//        out.println(stringFunction.apply("Текст"));

//        Function<PersonLambda,String> function = person -> person.toString();
//        out.println(function.apply(new PersonLambda("Vlad",23,6)));
    }

    public static void supplier(){
/*
    1. Генерация случайных чисел
    Используем Supplier для генерации случайного числа:
*/
        Supplier<Integer> supplier = () -> new Random().nextInt(1,5);
        out.println(supplier.get());

    //2. Создание объекта.
        Supplier<String> stringSupplier = () -> "new Object";
        out.println(stringSupplier.get());

    //3. Создание списка
        Supplier<List<String>> supplier1 = ArrayList::new;

    //4.

    }

    public static void predicate(){

        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13);

        Predicate<Integer> predicate = (integer) -> {
          if (integer > 5)
              return true;
          return false;
        };
        integers.stream().filter(predicate);

        Predicate<String> stringPredicate = (str) -> str.isEmpty();
        out.println(stringPredicate.test("Привет")); //false
        out.println(stringPredicate.test("")); // true
    }

    public static void main(String[] args) {
        predicate();
        //supplier();
        //consumer();
        //functionLambda();
        // Switcher sw = new Switcher();
        // Lamp lamp = new Lamp();
        // Radio radio = new Radio();

        // Вот это действие самое важное, с его помощью мы передаем ссылку.
        // Таким образом выключатель узнает про лампу.
        // Но узнает он не про класс Лампы, а про его объект и узнает это только тогда когда программа запущенно - runtime.
        // Это действие еще называется подписка на событие - event subscribe.
        //sw.elecricityConsumer = lamp;
        //sw.switchOn();

        // Подписка на событие.

        // Scanner sc = new Scanner(System.in);

        // sw.addElectricityListener(lamp);
        // sw.addElectricityListener(radio);
        // Анонимный класс
        // sw.addElectricityListener(new ElecricityConsumer() {
        //  @Override
        //    public void electricityOn(Object sender) {
        //        out.println("Пожар");
        //    }
        // });
        // Лямбда выражение - использование объекта как функции.
        // sw.addElectricityListener(sender -> out.println("Подписка на событие успешно"));
        //  sw.switchOn();

        // Runnable
        // Runnable привет = () -> out.println("Привет");
        // Callable

        //Callable<Integer> callable = () -> 47;
    }

}
