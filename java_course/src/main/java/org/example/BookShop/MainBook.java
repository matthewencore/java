package BookShop;

import java.util.Arrays;
import java.util.Scanner;

public class MainBook {
    public static void checkBook(Book[] book, String string,int price,int date) {
        for (Book b: book) {
            if (b == null) {continue;}
            if (string.equalsIgnoreCase(b.getName()) && b.getPrice() == price && b.getDateCreate() == date ) {
                System.out.println("Такая книга уже существует...");
                return;
            }

        }
        System.out.println("Ничего не нашёл в нашей скромной библиотеке)");

    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Book [] b1 = new Book[2];
        String input;
        int count = 0;
        int index = 0;
        while (true){
            System.out.println("Вы в главном меню, что бы выйти 'stop' %n| продолжить 'run' %n| информация 'info' %n" +
                    "| проверка check ");
            input = sc1.nextLine();
            if (input.equals("stop")) { break;}
            else if (input.equals("run")){
                if (count == b1.length){
                    System.out.println("Библиотека переполнена...");
                    continue;
                }

                System.out.println("Введите данные по книге");
                String author = sc1.nextLine();
                int price = sc1.nextInt();
                int date = sc1.nextInt();

                b1[index] = new Book(author, price, date);
                System.out.printf("Книга [%s] успешно создана %n",b1[index].getName());
                index++;
                count++;
                continue;

            } else if (input.equals("info")) {
                int count_ = 0;

                for (Book book : b1) {
                    if (book != null) {
                        count_++;
                }
                }
                System.out.printf("Текущий размер книг %s/%s %n",count_,b1.length);
                for (Book book : b1) {
                    if (book == null) {
                        System.out.printf("[Свободное место под книжку] %n");
                        continue;
                    }
                    System.out.printf("Книга [%s] | Цена [%s] | Дата [%s] %n", book.getName(), book.getPrice(), book.getDateCreate());
                }
            } else if (input.equals("check")) {
                checkBook(b1,sc1.nextLine(), sc1.nextInt(), sc1.nextInt());
            } else {
                continue;
            }

        }


    }

}


