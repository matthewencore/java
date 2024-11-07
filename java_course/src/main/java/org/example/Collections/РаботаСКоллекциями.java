package Collections;

import java.net.http.HttpClient;
import java.util.*;

public class РаботаСКоллекциями {
    public static void РаботаСМножествами(){
        Set<Integer> integers = new HashSet<>();
        integers.add(5);
        integers.add(69);
        integers.add(71);
        integers.add(82);
        integers.add(99);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            if (num > 10 ){
                continue;
            }
            System.out.println(num);
        }

    }
    public static void ДесятьТысячИтерацийСвязныйСписок(){
        long startTime = System.currentTimeMillis(); // Начало замера времени
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 1000000000 ; i++) {
            integers.add(1);
        }
        System.out.println(integers.size());
        long endTime = System.currentTimeMillis(); // Конец замера времени
        double durationInSeconds = (endTime - startTime) ; // Перевод в секунды

        System.out.println("Время выполнения: " + durationInSeconds + " мс");
    }
    public static void ДесятьТысячИтерацийСписок() {
        long startTime = System.currentTimeMillis(); // Начало замера времени
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            integers.add(1);
        }
        System.out.println(integers.size());
        long endTime = System.currentTimeMillis(); // Конец замера времени
        double durationInSeconds = (endTime - startTime); // Перевод в секунды

        System.out.println("Время выполнения: " + durationInSeconds + " мс");
    }
    public static void СоздатьДвеКоллекции() {
        List<String> strings = new ArrayList<>();
        List<String> strings1 = new LinkedList<>();
    }
    public static void ПереборЧерезИтераторИПроверкаНаТип() {
        Map<String,Object> objectMap = new HashMap<>();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("How are you do?");
        strings.add("Suck my dick");

        objectMap.put("1",4);
        objectMap.put("2",strings);
        objectMap.put("3", null);

        Iterator<Map.Entry<String, Object>> iterator = objectMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String,Object> stringObjectEntry = iterator.next();
            if(stringObjectEntry.getValue() instanceof ArrayList){
                System.out.println(" | Найден список");
                for (String string : strings) {
                    System.out.printf("   > %s%n", string);
                }
                continue;
            }
            System.out.printf("%s %n",stringObjectEntry.getValue());

        }


    }
    public static void ПоискСовпадающихСИменемИФамилий(){
        Map<String,String> map = new HashMap<>();
        map.put("Иванов","Иван");
        map.put("Николай","Николай");

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> stringStringEntry = iterator.next();
            if (stringStringEntry.getKey().equals(stringStringEntry.getValue())){
                System.out.printf(" | Match %s",(stringStringEntry.getKey() + " | " + stringStringEntry.getValue() ));
            }
        }


    }
    public static void ИспользованиеForEach8(){
        Map<String,String> stringStringMap = new HashMap<>();
        stringStringMap.put("key1","value");
        stringStringMap.put("key2","value");
        stringStringMap.put("key3","value");
        stringStringMap.put("key4","value");
        stringStringMap.put("key5","value");

        stringStringMap.forEach((key,value)
            -> System.out.println(key)
        );

    }
    public static void ИспользованиеForEach(){
        Map<String,String> map = new HashMap<>();
            map.put("key1","value");
            map.put("key2","value");
            map.put("key3","value");
            map.put("key4","value");
            map.put("key5","value");
        for (Map.Entry<String,String> item : map.entrySet()) {
            System.out.println(" " + item.getValue() + " " + item.getKey());
        }
    }
    public static void ИспользованиеForEachGet(){
        Map<String,String> map = new HashMap<>();
        map.put("key1","value");
        map.put("key2","value");
        map.put("key3","value");
        map.put("key4","value");
        map.put("key5","value");

        for (String row: map.keySet()) {
            System.out.println(row + " " + map.get(row));
        }
    }
    public static void ИспользованиеИтератора(){
        Map<String,String> map = new HashMap<>();
        map.put("key1","value");
        map.put("key2","value");
        map.put("key3","value");
        map.put("key4","value");
        map.put("key5","value");

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> stringStringEntry = iterator.next();
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }

    public static void main(String[] args) {
        ИспользованиеИтератора();
    }

}
