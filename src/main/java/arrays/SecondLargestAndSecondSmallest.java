package arrays;

import java.util.Arrays;

public class SecondLargestAndSecondSmallest {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        // find second largest and second smallest
        int largest = a[0];
        int smallest = a[0];
        int second_largest = Integer.MIN_VALUE;
        int second_smallest = Integer.MAX_VALUE;

        for(int i=1;i<a.length;i++) {
            if(a[i] > largest) {
                second_largest = largest;
                largest = a[i];
            } else if(a[i]>second_largest) {
                second_largest = a[i];
            }
            if(a[i]<smallest) {
                second_smallest = smallest;
                smallest = a[i];
            } else if (a[i]>smallest && a[i]<second_smallest) {
                second_smallest = a[i];
            }
        }
        return new int[]{second_largest,second_smallest};
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.stream(getSecondOrderElements(arr.length,arr))
                .forEach(System.out::println);
    }
}
