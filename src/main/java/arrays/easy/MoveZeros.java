package arrays.easy;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        // whenever a 0 is encounter then check for a non zero value in the remaining array
        // if found then swap both. This process will go on until we find no non zero value at the right.
        int count_zeros = 0;

        for(int x:nums) {
            if(x==0) count_zeros++;
        }
        int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i = 0;i<count_zeros;i++) {
            nums[nums.length-count_zeros+i] = 0;
        }
    }

    public static int[] moveZeros(int n, int []a) {
        int j = -1;
        //place the pointer j:
        // we will be finding the first occurence of 0.
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        // if there are no zero then we will be returning array as it is.
        if (j == -1) return a;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            // otherwise we will be swapping the value with the first non zero value which we have encountered.
            if (a[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,0,0,2,3,5};
        moveZeroes(arr);

        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
