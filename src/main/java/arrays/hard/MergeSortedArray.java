package arrays.hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedArray {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 6, 7, 8);
        List<Integer> l2 = Arrays.asList(2, 2, 3, 5, 6, 7, 8, 9);

//        List<Integer> solution = mergeSortedListBrute(l1,l2);
//        System.out.println(solution);
//        System.out.println(l1);
//        System.out.println(l2);
//        mergeWithoutExtraSpace(l1, l2);
        mergeUsingGapMethod(l1,l2);
        l1.forEach(System.out::println);
        l2.forEach(System.out::println);
    }

    private static void mergeUsingGapMethod(List<Integer> l1, List<Integer> l2) {
        int m = l1.size();
        int n = l2.size();
        int len = m+n;

        int gap = (len/2)+(len%2);

        while(gap > 0) {
            int left = 0;
            int right = left + gap;

            while(right < len) {
                if(left < m && right >= m) {
                    swapIfGreater(l1,l2,left,right-m);
                } else if(left>=m) {
                    swapIfGreater(l2,l2,left-m,right-m);
                } else {
                    swapIfGreater(l1,l1,left,right);
                }
                left++;
                right++;
            }

            if(gap==1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    private static void swapIfGreater(List<Integer> l1, List<Integer> l2, int left, int right) {
        System.out.println(left+":"+right);
        if (l1.get(left) > l2.get(right)) {
            int temp = l1.get(left);
            l1.set(left,l2.get(right));
            l2.set(right, temp);
        }
    }

    private static void mergeWithoutExtraSpace(List<Integer> l1, List<Integer> l2) {
        int i = l1.size()-1, j = 0, k = l2.size();

        while (i >= 0 && j < k) {
            if (l1.get(i) > l2.get(j)) {
                swap_index(l1, l2, i, j);
            }
            i--;
            j++;
        }
        Collections.sort(l1);
        Collections.sort(l2);
    }

    private static void swap_index(List<Integer> l1, List<Integer> l2, int i, int j) {
        int temp = l1.get(i);
        l1.set(i, l2.get(j));
        l2.set(j, temp);
    }

    private static List<Integer> mergeSortedListBrute(List<Integer> l1, List<Integer> l2) {
        List<Integer> solution = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = l1.size();
        int n = l2.size();

        while (i < m && j < n) {
            if (l1.get(i) < l2.get(j)) {
                solution.add(l1.get(i));
                i++;
            } else {
                solution.add(l2.get(j));
                j++;
            }
        }

        while (i < m) {
            solution.add(l1.get(i));
            i++;
        }

        while (j < n) {
            solution.add(l2.get(j));
            j++;
        }
        for (int k = 0; k < m + n; k++) {
            if (k < m) {
                l1.set(k, solution.get(k));
            } else {
                l2.set(k - m, solution.get(k));
            }
        }
        return solution;
    }
}
