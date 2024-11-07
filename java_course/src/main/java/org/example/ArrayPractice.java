import java.util.Scanner;

public class ArrayPractice {
    public void initializeArray() {
        int [] arr1 = new int[20];
        Scanner sc1 = new Scanner(System.in);

        for (int i = 0; i < arr1.length ; i++) {
            System.out.printf("ArrayFill i:[%s] :> ",i);
            arr1[i] = sc1.nextInt();
        }
        System.out.printf("Максимальное число [%s]",max(arr1));
    }

    public StringBuilder reverseArray(int[] arr) {
        StringBuilder str1 = new StringBuilder();
        for (int i = arr.length -1; i > -1 ; i--) {
            str1.append(" ").append(arr[i]);
        }
        return str1;
    }


    public int max (int [] num) {
        if (num.length != 0){
            int max = num[0];
            for (int i = 0; i < num.length ; i++) {
                if (num[i] > max) {
                    max = num[i];
                }
            }
            return max;
        }
        return  0;
    }
}
