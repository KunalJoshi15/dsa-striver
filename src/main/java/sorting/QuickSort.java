package sorting;

public class QuickSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        quick_sort(arr,0,arr.length-1);
    }

    private void quick_sort(int[] arr, int low,int high) {
        if (low<high) {
            int partition = find_partition(arr, low, high);
            quick_sort(arr, low, partition - 1);
            quick_sort(arr, partition + 1, high);
        }
    }
    // the time complexity for merge sort and quick sort are same.
    // we pick a particular element then we place that element to its correct position.
    // when a particular element is in its correct position all the elements which are smaller will be on the left while all the elements which
    // are larger will be on the right side.
    private int quick_sort_striver(int[] arr,int low,int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i<j) {
            while (arr[i]<=pivot && i<=high-1) {
                i++;
            }

            while (arr[j] > pivot && j > low+1) {
                j--;
            }
            if (i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }

    private int find_partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int k = (low-1);

        for(int j=low;j<=high-1;j++) {
            if (arr[j]<pivot) {
                k++;
                swap(arr, k, j);
            }
        }
        swap(arr,k+1,high);
        return k+1;
    }

    private static void swap(int[] arr, int k, int j) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}
