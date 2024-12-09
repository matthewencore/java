package Algoritms;

import java.util.*;

public class Algorithm {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(11);
        list.add(26);
        list.add(9);
        list.add(3);
        list.add(8);

        selectionSort(list);

        System.out.println(list);


    }
    public static void selectionSort(List<Integer> a) {
        for (int i = 0; i < a.size() -1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j) < a.get(indexMin)){
                    indexMin = j;
                }
            }
            int tempNumber = a.get(i);
            a.set(i,a.get(indexMin));
            a.set(indexMin, tempNumber);
        }
    }

    private static void quicksort1(List<Integer> integers, int low, int high) {
        if (low < high) {
           int indexPivot = partition1(integers, low,high);
           quicksort1(integers,low,indexPivot - 1);
           quicksort1(integers,indexPivot,high);
           }
    }

    private static int partition1(List<Integer> integers, int low, int high) {
        int lowGranice = low;
        int highGranice = high;

        int pivot = integers.get(low);

        while (lowGranice <= highGranice) {
            while (integers.get(lowGranice) < pivot){
                lowGranice++;
            }
            while (integers.get(highGranice) > pivot){
                highGranice--;
            }
            if (lowGranice <= highGranice) {
                swap1(integers,lowGranice,highGranice);
                lowGranice++;
                highGranice--;
            }
        }
        return lowGranice;
    }

    private static void swap1(List<Integer> integers, int lowGranice, int highGranice) {
        int temp1 = integers.get(lowGranice); // Сохраняем значение элемента по индексу lowGranice
        integers.set(lowGranice, integers.get(highGranice)); // Меняем элемент по индексу lowGranice на элемент по индексу highGranice
        integers.set(highGranice, temp1); // Меняем элемент по индексу highGranice на сохраненное значение temp1
    }

    // Алгоритм бинарного поиска
    static public boolean bSearch(ArrayList<Integer> intList, int guestNumber){
        Collections.sort(intList);
        int low = 0;
        int high = intList.size() - 1;
        int mid;

        while (low <= high){
           mid = (low + high) /2;
           int getNumber = intList.get(mid);

           if (getNumber == guestNumber){
               return true;
           } else if (getNumber < guestNumber) {
               low = mid + 1;
           } else {
               high = mid - 1;
           }
        }
        return false;
    }

    private static int minNumber(ArrayList<Integer> list){
        int minValue = list.getFirst();
        int indexValue = 0;
        for (int i = 0; i < list.size() ; i++) {
          if(list.get(i) < minValue){
              minValue = list.get(i);
              indexValue = i;
          }
        }
        return indexValue;
    }

    public static ArrayList<Integer> selectSort(ArrayList<Integer> list){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while (list.size() != 0){
            int indexNumber = minNumber(list);
            integerArrayList.add(list.get(indexNumber));

            list.remove(indexNumber);
        }

        return integerArrayList;
    }

    public static void recursion(int i){
        System.out.println(i);
        if (i <= 1) return;
        else recursion(i-1);
    }

    public static void quicksort(int [] arr, int from , int to){
        if (from < to){
            int divideIndex = partition(arr,from,to);
            quicksort(arr,from,divideIndex - 1);
            quicksort(arr, divideIndex, to);

        }
    }

    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;
        int pivot = arr[from];
        while (leftIndex <= rightIndex){
            while (arr[leftIndex] < pivot){
                leftIndex++;
            }
            while (arr[rightIndex] > pivot){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                swap(arr,rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }


        return leftIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;

    }



}
