package sorting;

import java.util.Arrays;

public class ArraySorter {

    public static void main(String[] args) {
        Sorting sorting = new InsertionSort();

        int arrp[] = {1,21,1,-2,3,1,2,5,6,7};
        sorting.sort(arrp);

        Arrays.stream(arrp)
                .forEach(System.out::println);
    }
}
