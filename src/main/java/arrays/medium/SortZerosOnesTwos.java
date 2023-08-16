package arrays.medium;

import java.util.* ;
import java.io.*;
public class SortZerosOnesTwos {
    public static void swap(ArrayList<Integer> arr,int i,int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        // We can use the dutch national flag algorithm for sorting the array.
        int low = 0;
        int mid = 0;
        int high = n-1;
        // intuition behind this is that array from mid to high is not sorted
        while(mid<=high) {
            switch(arr.get(mid)) {
                case 0:
                    swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(0);
        integerList.add(2);
        sortArray(integerList,integerList.size());
        integerList.stream()
                .forEach(System.out::println);

    }
}

