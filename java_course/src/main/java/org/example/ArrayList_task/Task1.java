package ArrayList_task;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Строка1");
        strList.add("Строка2");
        strList.add("Строка3");
        strList.add("Строка4");
        strList.add("Строка5");
        System.out.printf("Размер списка %s %n",strList.size());

        for (String str : strList) {
            System.out.println(str);
        }
    }
}
