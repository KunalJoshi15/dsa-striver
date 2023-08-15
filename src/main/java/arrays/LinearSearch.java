package arrays;

public class LinearSearch {
    public static int linearSearch(int n, int num, int []arr){
        // Write your code here.
        return linearSearchUtil(0,num,arr);
    }

    public static int linearSearchUtil(int i,int num,int []arr) {
        if (i>=arr.length) return -1;

        // System.out.println(i);
        if(arr[i]==num) return i;
        return linearSearchUtil(i+1, num, arr);
    }
}
