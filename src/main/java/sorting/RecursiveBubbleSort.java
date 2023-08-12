package sorting;

public class RecursiveBubbleSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        // largest element goes to the last index in case of bubble sort.
        bubble_sort(arr, 0);
    }

    private void bubble_sort(int[] arr, int i) {
        if (i==arr.length) return;

        for (int j=0;j<arr.length-i-1;j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

        bubble_sort(arr,i+1);
    }
}
