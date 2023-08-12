package sorting;

public class InsertionSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int picked = arr[i];
            int j = i-1;

            while(j>=0 && picked<arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = picked;
        }
    }
}
