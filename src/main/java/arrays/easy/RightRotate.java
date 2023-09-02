package arrays.easy;

import java.util.Arrays;

public class RightRotate {
    public static void rotate(int[] nums, int k) {
        int rem[] = new int[k];
        if(nums.length==1) return;
        k = k%nums.length;
        for(int i=0;i<k;i++) {
            rem[i] = nums[nums.length-k+i];
        }

        for(int i=nums.length-1;i>=k;i--) {
            nums[i] = nums[i-k];
        }

        for(int i=0;i<k;i++) {
            nums[i] = rem[i];
        }
    }

    public void rotateOptimal(int[] nums, int k) {
        k = k%nums.length;
        reversal(nums, nums.length-k,nums.length-1);
        reversal(nums, 0, nums.length-k-1);
        reversal(nums, 0, nums.length-1);
    }

    public void reversal(int[] nums,int start,int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
        rotate(arr,5);
        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
