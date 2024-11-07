package LifeCat;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class Cat {
    private String nameCat = "";
    private double weightCat = 0;
    private int age = 0;
    private double hungryValues = 0;
    private double wannaPlay = 0;

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public double getWeightCat() {
        return weightCat;
    }

    public void setWeightCat(double weightCat) {
        this.weightCat = weightCat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHungryValues() {
        return hungryValues;
    }

    public void setHungryValues(double hungryValues) {
        if (this.hungryValues >= 100 || hungryValues + this.hungryValues >= 100) this.hungryValues = 100;
        else this.hungryValues = hungryValues;

        if (this.hungryValues <= 0 || hungryValues + this.hungryValues <=0) this.hungryValues = 0;

    }

    public double getWannaPlay() {
        return wannaPlay;
    }

    public void setWannaPlay(double wannaPlay) {
        if (this.wannaPlay >= 100 || this.wannaPlay + wannaPlay >= 100){
            this.wannaPlay = 100;
        } else {
            this.wannaPlay = wannaPlay;
        }

    }

    public Cat() {}

    public Cat(String nameCat, double weightCat, int age) {
        this.nameCat = nameCat;
        this.weightCat = weightCat;
        this.age = age;
    }

    public void menuCat() {
        int exp = 0;
        if (Objects.equals(nameCat, "") && weightCat == 0 && age == 0){
            System.out.println("Ваш кот не создан, перейдем к созданию");

            System.out.println("Введите имя кота :> ");
            Scanner scanner = new Scanner(System.in);
            setNameCat(scanner.next());

            System.out.println("Введите возраст кота :> ");
            Scanner scanner2 = new Scanner(System.in);
            setAge(scanner2.nextInt());

            System.out.println("Введите вес кота :> ");
            Scanner scanner3 = new Scanner(System.in);
            setWeightCat(scanner3.nextDouble());

        }
        statusCat();
        while (true){
            exp++;
            if (exp == 20) {
                setAge(getAge() + 1);
                exp = 0;
                System.out.println("Поздравляем ваш кот вырос на 1 годик!!!");
            }

            System.out.printf("\n" +
                    "1 ------ Покушать   %n" +
                    "2 ------ Статистика %n" +
                    "3 ------ Играть     %n");
            Scanner sc1 = new Scanner(System.in);
            switch (sc1.nextInt()){
                case 1:
                    tastyCat();
                    continue;
                case 2:
                    statusCat();
                    continue;
                case 3:
                    playKitty();
                    continue;
                default:
                    System.out.println("Такой команды нет.");
            }
        }
    }
    public void statusCat(){
        System.out.printf("Вы попали в меню вашего кота %n" +
                        " Имя: ---------- [%s] %n" +
                        " Возраст: ------ [%s] %n" +
                        " Вес: ---------- [%s] %n" +
                        " -------------------- %n" +
                        " Голод: -------- [%s] %n" +
                        " Игривость ----- [%s] %n",

                getNameCat(),
                getAge(),
                getWeightCat(),
                getHungryValues(),
                getWannaPlay()

        );
    }
    public void tastyCat(){
        System.out.printf("Выбирите корм на ваше усмотрение %n" +
                "Маленький корм - '1'%n" +
                "Средний корм   - '2'%n" +
                "Большой корм   - '3'%n" +
                " " +
                "Перестать кормить - 0");

        Scanner sc1 = new Scanner(System.in);

        while (true) {
            if (getHungryValues() > 50){
                System.out.println("Кажется он не сильно голоден...");
                return;
            }
            switch (sc1.nextInt()) {

                case 1:
                    setHungryValues(getHungryValues() + 15);
                    setWeightCat(getWeightCat() + 0.1);
                    System.out.println("+ маленький корм");
                    continue;
                case 2:
                    setHungryValues(getHungryValues() + 45);
                    setWeightCat(getWeightCat() + 0.3);
                    System.out.println("+ средний корм");
                    continue;
                case 3:
                    setHungryValues(getHungryValues() + 80);
                    setWeightCat(getWeightCat() + 0.5);
                    System.out.println("+ большой корм");
                    continue;
                case 0:
                    return;
                default:
                    System.out.println("Такого корма на складе нет :) ");
                    continue;
            }
        }

    }
    public void playKitty(){
        if (getHungryValues() >= 0 && getHungryValues() <=20) {
            System.out.println("Не хочу играть!! я голоден или переел");
            return;
        } else if (getWannaPlay() >= 100) {
            System.out.println("Не хочу играть!! я и так уже наигрался");
            return;
        }
        System.out.println("Что бы играть нажмите - p, что бы закончить S");
        Scanner sc1 = new Scanner(System.in);

        while (true){
            switch (sc1.next()){
                case "p":
                    setWannaPlay(getWannaPlay() + 25);
                    setWeightCat(getWeightCat() - 0.1);
                    setHungryValues(getHungryValues() - 10);
                    continue;
                case "s","S":
                    return;
                default:
                    System.out.println("Такой игры нет...");
                    continue;
            }

        }

    }
}
