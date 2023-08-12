package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        merge_sort(arr,0,arr.length-1);
    }

    private void merge_sort(int[] arr, int low, int high) {
        if (low>=high) return;
        int mid = (low+high)/2;
        merge_sort(arr,low,mid);
        merge_sort(arr,mid+1,high);
        merge_order(arr,low,mid,high);
    }

    private void merge_order(int[] arr,int low,int mid,int high) {
        int n1 = mid-low+1;
        int n2 = high-mid;
        int left[] = new int[n1+1];
        int right[] = new int[n2+1];

        for(int i=0;i<n1;i++) {
            left[i] = arr[low+i];
        }
        for (int j=0;j<n2;j++) {
            right[j] = arr[mid+j+1];
        }

        int i=0,j=0;

        int k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> aux = new ArrayList<>();
        int i = low;
        int j = mid+1;
        while(i<=mid && j<=high) {
            if (arr[i]<arr[j]) {
                aux.add(arr[i]);
                i++;
            } else {
                aux.add(arr[j]);
                j++;
            }
        }

        while(i<=mid) {
            aux.add(arr[i]);
            i++;
        }

        while (j<=high) {
            aux.add(arr[j]);
            j++;
        }

        for (i=low;i<=high;i++) {
            arr[i] = aux.get(i-low);
        }
    }
}
