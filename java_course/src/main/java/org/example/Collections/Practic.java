package org.example.Collections;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Worker{
    private final Queue tasks;

    public Worker(Queue tasks) {
        this.tasks = tasks;
    }

    void get_task(){
        if (tasks.isEmpty()) {
            System.err.println("Очередь пуста, задач нет.");
            return;
        }

        if (tasks.poll() != null) {
            System.out.println("" + tasks.poll());
            return;
        }
    }

}

class Boss {
    private final Queue tasks;
    private final int limitTasks = 5;

    public Boss(Queue tasks) {
        this.tasks = tasks;
    }

    void create_task(){
        if (tasks.size() >= 0 && tasks.size() <= 5 ){
            Scanner sc = new Scanner(System.in);
            System.out.println("Задача добавлена: " + tasks.add(sc.nextLine()));
        }

    }


}

public class Practic {
    public static void main(String[] args) {
        Queue queue = new ArrayDeque();
        Worker w = new Worker(queue);
        Boss b = new Boss(queue);

        Scanner sc = new Scanner(System.in);

        while (true) {
            switch (sc.nextLine().toLowerCase()) {
                case "add":
                    b.create_task();
                    continue;
                case "job":
                    w.get_task();
                    continue;
                case "out":
                    for (Object item: queue) {
                        System.out.println(item);
                    }
                    continue;
                case "exit":
                    return;

            }
        }

    }
}
