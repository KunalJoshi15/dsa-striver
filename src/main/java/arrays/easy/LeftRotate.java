package arrays.easy;

import java.util.Arrays;

public class LeftRotate {

    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.
        int first = arr[0];

        for(int i=1;i<n;i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = first;
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.stream(rotateArray(arr,arr.length))
                .forEach(System.out::println);
    }
}
