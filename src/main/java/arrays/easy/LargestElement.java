package arrays.easy;

public class LargestElement {

    public static void main(String[] args) {
        int arr[] = {2,1,2,3,4,5,6,6,1,22};
        System.out.print(findLargest(arr));
    }

    private static int findLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;

        for (int x:arr) {
            largest = Math.max(largest,x);
        }
        return largest;
    }
}
