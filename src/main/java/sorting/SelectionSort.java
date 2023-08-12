package sorting;

public class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        // the working of selection sort is as follows. we select the current element and then places it to its correct position.
        for (int i=0;i<arr.length-1;i++) {
            int mini = i;
            for(int j=i+1;j<arr.length;j++) {
                // we will be placing the element to its correct position.
                if(arr[mini]>arr[j]) {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
}
