
import Algoritms.Algorithm;
import Storage.Storage;

import java.awt.*;
import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Arrays.sort;

class Main {

    public static void storage(){
        Storage [] st = new Storage[12];
        st[0] = new Storage(
                "Телефон",
                5,
                "Вьетнам",
                "Кирилл"
        );

        st[1] = new Storage(
                "Ноутбук",
                3,
                "Китай",
                "Кирилл"
        );
        st[2] = new Storage();
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.printf(" Конфигурация | Склад 1.0 для самых маленьких и тупых!%n " +
                    " | info - информация о всех предметах склада%n " +
                    " | add - добавить на склад предмет %n" +
                    " :> ");
            switch (input.nextLine()){
                case "info":
                    System.out.println("Информация по складу");
                    for (Storage item : st ) {
                        if (item == null) {continue;}
                        System.out.printf("%n %s | %s | %s | %s",
                                item.getItemName(),
                                item.getCount(),
                                item.getCountryMake(),
                                item.getOwner());
                    }
                    continue;
                case  "add":
                    Storage.addItem(st[1]);
                    continue;
                default:
                    System.out.println();
            }

        }
    }
    public static void calculate() {
        Scanner sc1 = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;

        while(true){

            if (num1 == 0 && num2 == 0) {
                System.out.println("Введите первое число:> ");
                num1 = sc1.nextInt();

                System.out.println("Введите второе число:> ");
                num2 = sc1.nextInt();

            } else if (num1 != 0 && num2 == 0) {
                System.out.printf("Введите второе число которое будет работать с %s:> ",num1);
                num2 = sc1.nextInt();
            }

            System.out.printf("Введите операцию:> " +
                    "Доступные операции %n" +
                    "   + %n" +
                    "   - %n" +
                    "   * %n" +
                    "   / %n" +
                    "   C - обнуление результата %n" +
                    "   S - выйти из цикла       %n");

            String str1 = sc1.next();
            char ch1 = str1.charAt(0);
            switch (ch1){
                case '+':
                    num1 += num2;
                    System.out.println(num1);
                    num2 = 0;
                    continue;
                case '-':
                    num1 -= num2;
                    System.out.println(num1);
                    num2 = 0;
                    continue;
                case '*':
                    num1 *= num2;
                    System.out.println(num1);
                    num2 = 0;
                    continue;
                case '/':
                    if (num2 != 0) {
                        num1 /= num2;
                        System.out.println(num1);
                    } else {
                        System.out.println("Ошибка: Деление на ноль невозможно.");
                    }
                    num2 = 0;
                    continue;
                case 's','S':
                    System.out.println("Заканчиваю работу...");
                    return;
                case 'c','C':
                    num1 = 0;
                    System.out.println("Обнуляем результат...");
                    num2 = 0;
                    continue;
                default:
                    System.out.println("Калькулятор выполняет только тривиальные операции.");
                    continue;


            }

        }
    }
    public static void Потная(){
        /*Дан массив: {27, 97, 86, 88, 31, 46, 59, 48, 16, 4}.
        Вывести его в обратном порядке. Затем отсортировать в порядке убывания.*/

        int [] array = {27, 97, 86, 88, 31, 46, 59, 48, 16, 4};
        for (int i = 0, j = array.length -1; i < array.length / 2 ; i++, j--) {
            int x = array[i];
            int y = array[j];

            array[i] = y;
            array[j] = x;
        }
        System.out.println(Arrays.toString(array));

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int [] arrayCopy = array.clone();


        for (int i = 0; i < arrayCopy.length; i++) {
            int largeNum = arrayCopy[i];
            int indexLargeNum = 0;
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < arrayCopy.length; j++) {
                if (arrayCopy[j] >= largeNum){
                    largeNum = arrayCopy[j];
                    indexLargeNum = j;
                }
                //row.append("[ ").append(arrayCopy[i]).append(" | ").append(arrayCopy[j]).append(" ]");
            }
            integerArrayList.add(largeNum);
            arrayCopy[indexLargeNum] = 0;
        }
        System.out.println(integerArrayList);
    }

    public static void textCmd(){
        ArrayList<String> text = new ArrayList<>();


        while (true){
            Scanner sc1 = new Scanner(System.in);
            System.out.printf("Меню%n " +
                    "| pr - напечатать текст%n " +
                    "| + - добавить строку%n " +
                    "| cl - очистить текст%n " +
                    "| ed - режим редактирования%n");
            String str = sc1.next();
            switch (str){
                case "pr":
                    System.out.printf("%n");
                    System.out.println("-------------------------------");
                    for (int i = 0; i < text.size() ; i++) {
                        System.out.printf("%s | %s %n", i+1,text.get(i));
                    }
                    System.out.println("-------------------------------");
                    System.out.printf("%n");
                    continue;
                case "+":
                    int rowIndex = 0;
                    System.out.printf("Режим добавления строк, что бы выйти%n | /exit%n");
                    while(true){
                        rowIndex++;
                        Scanner sc2 = new Scanner(System.in);
                        System.out.printf("Строка #[%s]%n :>",rowIndex);
                        String row = sc2.nextLine();
                        if (row.equals("/exit")) break;
                        if (row.isEmpty()) continue;
                        text.add(row);
                        System.out.println("Добавлено");
                    }
                    continue;
                case "cl":
                    text.clear();
                    System.out.println("Очищено");
                    continue;
                case "ed":
                    boolean isRun = true;
                    System.out.printf("Режим редактирования %n " +
                            "| /exit - выйти из режима редактирования%n " +
                            "| tr - удалить все двойные пробелы%n " +
                            "| cap - сделать все символы заглавными%n " +
                            "| len - посчитать все символы в тексте%n " +
                            "| set - заменить строчку%n ");
                    while (isRun){
                        Scanner sc3 = new Scanner(System.in);
                        String string = sc3.nextLine();
                        if (string.isEmpty()) continue;
                        switch (string){
                            case "/exit":
                                System.out.println("Выхожу с режима редактирования");
                                isRun = false;
                                break;
                            case "tr":
                                if (text.isEmpty()){
                                    System.out.println("Текст пустой, заполните пожалуйста");
                                    isRun = false;
                                    break;
                                }
                                for (int i = 0; i < text.size() ; i++) {
                                    String currentWithoutDouble = text.get(i);
                                    text.set(i,currentWithoutDouble.replace("  ",""));
                                }
                                System.out.println("Готово");
                                break;
                            case "cap":
                                if (text.isEmpty()){
                                    System.out.println("Текст пустой, заполните пожалуйста");
                                    isRun = false;
                                    break;
                                }
                                for (int i = 0; i < text.size(); i++){
                                    String capText = text.get(i);
                                    text.set(i, capText.toUpperCase());
                                }
                                break;
                            case "len":
                                int lenSumm = 0;
                                for (String row : text) {
                                    lenSumm += row.length();
                                }
                                System.out.printf("Количество символов текста: [%s]",lenSumm);
                                break;
                            case "set":
                                Scanner sc4 = new Scanner(System.in);
                                System.out.printf("%n");
                                System.out.println("------Выбирайте строчку для редактирования-----");
                                for (int i = 0; i < text.size() ; i++) {
                                    System.out.printf("%s | %s %n", i+1,text.get(i));
                                }
                                System.out.println("------Выбирайте строчку для редактирования-----");
                                System.out.printf("%n");

                                System.out.println(":> ");
                                int numberRow = sc4.nextInt();

                                System.out.printf("Ваш выбор %n | %s %n",text.get(numberRow-1));

                                Scanner sc5 = new Scanner(System.in);
                                String editRow = "";
                                System.out.println("Введите новый текст для строчки");
                                editRow = sc5.nextLine();
                                text.set(numberRow - 1,editRow);
                                System.out.println("Изменено");
                                break;

                        }

                    }
                default:
                    System.out.println(" ");
                    continue;
            }

        }
    }

    public static AtomicReference<StringBuilder> task1_() {
        try {
            AtomicReference<StringBuilder> str1 = new AtomicReference<>(new StringBuilder());

            for (int i = 0; i < 20 ; i+= 2) {
                str1.get().append(" ").append(i);

            }

            return str1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static AtomicReference<StringBuilder> task1() {
        AtomicReference<StringBuilder> result = new AtomicReference<>(new StringBuilder());
        for (int i = 1; i < 20; i++) {
            if (i % 2 != 0){
                continue;
            }
            result.get().append(" ").append(i);

        }
        return result;
    }

    public static void main(String[] args) {
        Algorithm.recursion(100);
    }
}