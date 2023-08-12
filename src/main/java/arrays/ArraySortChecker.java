package arrays;

public class ArraySortChecker {
    public static int isSorted(int n, int []a) {
        // Write your code here.
        if(n==2) {
            if(a[n-1]>=a[n-2]) return 1;
            return 0;
        }
        if(n==1) return 1;

        int checkSort = isSorted(n-1, a);
        if(checkSort==1) {
            if(a[n-1]>=a[n-2]) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,0,0,1};
        System.out.print(isSorted(arr.length,arr));
    }
}
