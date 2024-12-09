package org.example.OOP;

import java.util.ArrayList;
import java.util.List;
// Класс айтема
class Item{
    private String name;

    public Item(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}

class Human{
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    class Brain{
        int iq;

        public Brain(int iq) {
            this.iq = iq;
        }

        void think(){
            System.out.printf("%s думает",Human.this.name);
        }
    }
}

class Player extends Human{

    class Backpack {
        // Размер инвентаря
        private List<Item> items = new ArrayList<>(25);

        void addItem(String item){
            items.add(new Item(item));
        }

        void allItem(){
            for (Item item: items) {
                System.out.println(item.getName());
            }
        }
    }

    Backpack backpack;

    public Player(String name, int age) {
        super(name, age);
        backpack = new Backpack();
    }

    public Backpack getBackPack() {
        return backpack;
    }

}

public class InnerClasses {

    public static void main(String[] args) {
        Player player = new Player("Алексей", 25);

        // Получаем его рюкзак и добавляем предметы
        Player.Backpack backPack = player.getBackPack();
        backPack.addItem("Меч");
        backPack.addItem("Щит");
        backPack.addItem("Зелье здоровья");

        // Выводим все предметы
        backPack.allItem();
    }
}
