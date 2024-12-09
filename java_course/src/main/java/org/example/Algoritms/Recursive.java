package org.example.Algoritms;

class Task{
    // 1 + 2 + 3 = 6
    // B = 6 - A - C
    // buf = 6 - src - dst
    void han(int size, int indexSRC, int indexDST){
        if (size ==1) {
            System.out.printf("Перемещаем блок номер 1 из %s к %s",indexSRC,indexDST);
            System.out.println();
            return;
        }

        int indexBufSource = 6 - indexSRC - indexDST; // Индекс буферного столбика

        han(size - 1, indexSRC, indexBufSource);
        System.out.printf("Перемещаем блок номер %s из %s к %s",size,indexSRC,indexDST);
        System.out.println();
        han(size - 1, indexBufSource, indexDST);
    }

    int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    int fib(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }
}


public class Recursive {

    public static void main(String[] args) {
        Task t = new Task();
        System.out.println(t.fib(4));
    }
}
