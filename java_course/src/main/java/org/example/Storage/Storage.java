package Storage;

import java.util.Scanner;

public class Storage {
    private String uid;
    private String itemName;
    private int count;
    private String countryMake;
    private String owner;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCountryMake() {
        return countryMake;
    }

    public void setCountryMake(String countryMake) {
        this.countryMake = countryMake;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Storage() {}

    public Storage(String itemName, int count, String countryMake, String owner) {
        this.itemName = itemName;
        this.count = count;
        this.countryMake = countryMake;
        this.owner = owner;
    }


    public void infoItem(){
        if (getItemName() == null){
            System.out.println(" | Не указано имя предмета, который вы хотели бы получить.");
            return;
        }

        System.out.printf("Информация о предмете %n" +
                " Наименование: | %s %n" +
                " Количество:   | %s %n" +
                " Владелец:     | %s %n" +
                " Производитель | %s %n",
                getItemName(),
                getCount(),
                getOwner(),
                getCountryMake()
                );
    }

    public static Storage addItem(Storage item){
        if (item == null){
            System.out.println("Объекта не существует, выделите ячейку под предмет.");
            return null;
        }

        if (item.getItemName() != null){
            System.out.println("Ячейка под это занята!");
            return item;
        }
        Scanner sc1 = new Scanner(System.in);
        System.out.println(" Склад | Введите название предмета");
        String nameItem = sc1.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println(" Склад | Введите количество предмета");
        int count = sc1.nextInt();

        Scanner sc3 = new Scanner(System.in);
        System.out.println(" Склад | Введите владельца предмета");
        String owner = sc3.nextLine();

        Scanner sc4 = new Scanner(System.in);
        System.out.println(" Склад | Введите производителя предмета");
        String maker = sc4.nextLine();

        System.out.printf("Создано: %n" +
                        " Наименование: | %s %n" +
                        " Количество:   | %s %n" +
                        " Владелец:     | %s %n" +
                        " Производитель | %s %n",
                nameItem,
                count,
                owner,
                count
        );

        return new Storage(nameItem,count,owner,maker);
    }

}
