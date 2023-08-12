package basicrecursion;

import java.util.Arrays;

public class BasicRecursion {

    public static void main(String[] args) {
//        printNTimes(5);
//        print1ToN(5);
//        System.out.print(sumN(8));
        System.out.print(fibonacciSeries(6));
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9 };
        // 2 4 3 2 1 3 2 1
        reverseArray(arr,0);
//        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void reverseArray(int[] arr,int i) {
        if(i==arr.length) return;

        reverseArray(arr,i+1);
        int temp = arr[i];
        for(int j=i+1;j<arr.length;j++) {
            arr[j-1] = arr[j];
        }
        arr[arr.length-1] = temp;
    }

    private static int sumN(int i) {
        if (i==0) return 0;

        return i+sumN(i-1);
    }

    private static void print1ToN(int i) {
        if (i==0) return;
        print1ToN(i-1);
        System.out.println(i);
    }

    private static int fibonacciSeries(int n) {
        if(n==0 || n==1) return n;

        return fibonacciSeries(n-1)+fibonacciSeries(n-2);
    }

    private static void printNTimes(int i) {
        if(i==0) return;
        System.out.println("Hello World");
        printNTimes(i-1);
    }
}
