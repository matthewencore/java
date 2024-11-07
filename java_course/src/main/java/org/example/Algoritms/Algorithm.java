package Algoritms;

import java.util.*;

public class Algorithm {

    public static void main(String[] args) {
//        int [] arr = new int[] {4,1,10,55,33,66,99,7,15,21,39,45};
//        quicksort(arr,0,arr.length - 1);
//        StringBuilder str1 = new StringBuilder();
//
//        Iterator<Integer> integerIterator = Arrays.stream(arr).iterator();
//        while (integerIterator.hasNext()){
//            str1.append(" ").append(integerIterator.next());
//        }
//        System.out.println(str1);
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(17);
        integers.add(1);
        integers.add(9);
        integers.add(91);
        integers.add(35);
        integers.add(71);

        quicksort1(integers,0,integers.size() - 1);
        StringBuilder string = new StringBuilder();
        Iterator<Integer> integerIterator = integers.iterator();

        while (integerIterator.hasNext()){
            string.append(" ").append(integerIterator.next());
        }
        System.out.println(string);
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
