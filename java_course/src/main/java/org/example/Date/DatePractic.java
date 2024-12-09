package org.example.Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DatePractic {

    public static void main(String[] args) {
        period();
    }

    // Работа с датами
    public static void localdate(){
        LocalDate lt = LocalDate.of(2024,12,5);
        System.out.println(lt);

    }

    // Работа с датами2
    public static void localDate2(){
        LocalDate lt = LocalDate.of(2024,12,5);
        // Не изменится , потому что immutable
        lt.plusDays(10);
        // Будет работать
        lt = lt.plusDays(10);
        System.out.println(lt);
    }

    // Разница между датами LocalDate
    public static void localdate3(){
        LocalDate lt = LocalDate.of(2023,12,5);
        LocalDate lt2 = LocalDate.of(2024,1,2);

        Period p = Period.between(lt,lt2);
        System.out.printf("""
                Разница между датами
                %s год, %s месяц(-ев), %s дней
                """,p.getYears(),p.getMonths(),p.getDays());


    }

    // Увелеченние на 1
    public static LocalDate localdate(LocalDate ld) {
        // Если пусто
        if (ld == null) {
            LocalDate _ld = LocalDate.now();
            return _ld;
        }
        // Не забываем про имутабельность типов
        ld = ld.plusWeeks(1);

        return ld;
    }

    // Дата и время одновременно
    public static void localDateTime(){

    }

    public static void localDateTime2(){
        LocalDateTime localDateTime = LocalDateTime.of(2024,11,20,15,20,0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2025,5,17,21,40,37);

        LocalDate ld = localDateTime.toLocalDate();
        LocalDate ld2 = localDateTime2.toLocalDate();

        LocalTime lt = localDateTime.toLocalTime();
        LocalTime lt2 = localDateTime2.toLocalTime();

        System.out.println(ld);
        System.out.println(ld2);
        System.out.println(lt);
        System.out.println(lt2);

        lt = lt.plus(10, ChronoUnit.HOURS);
        System.out.println(lt);


    }

    // Дата с тайм-зоной
    public static void zDate(){
        DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
         ZonedDateTime zonedDateTime =  ZonedDateTime.of(
               LocalDate.of(2024,10,11), LocalTime.of(10,10),ZoneId.of("Europe/Moscow")
        );

        System.out.println(zonedDateTime.format(dateTimeFormatter));
    }

    // Парсинг даты
    public static void parseDate(){
        String date = "14-12-2024";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
        LocalDate ld = LocalDate.parse(date,dateTimeFormatter);
        System.out.println(ld.format(dateTimeFormatter));

    }

    public static void period(){
        LocalDate ld = LocalDate.of(2024,12,10);
        LocalDate ld2 = LocalDate.of(2024,1,10);
        Period p = Period.between(ld,ld2);

        System.out.println(p);
    }

}

