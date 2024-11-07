package Algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
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
}
