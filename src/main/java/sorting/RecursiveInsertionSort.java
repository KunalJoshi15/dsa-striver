package sorting;

public class RecursiveInsertionSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        insertion_sort(arr,1);
    }

    private void insertion_sort(int[] arr, int i) {
        if (i==arr.length) return;
        int curr = arr[i];
        int j = i-1;

        while (j>=0 && curr < arr[j]) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = curr;
        insertion_sort(arr,i+1);
    }
}
