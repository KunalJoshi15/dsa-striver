package arrays.medium;

import java.util.Arrays;

public class PermutationArray {

    public static void main(String[] args) {
        int nums[] = new int[]{4,3,2,1};

        next_permutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void swap(int []nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int []nums,int start,int end) {
        while (start<=end) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private static void next_permutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        for(int i=n-2;i>=0;i--) {
            if (nums[i]<nums[i+1]) {
                ind = i;
                break;
            }
        }

        if (ind==-1) {
            // if there is no sudden change in the values then we will be simply
            reverse(nums, 0,n-1);
        } else {
            int rep = 0;
            for (int i=n-1;i>=0;i--) {
                if(nums[ind] < nums[i]) {
                    rep = i;
                    break;
                }
            }
            swap(nums,ind,rep);
            reverse(nums,ind+1,n-1);
        }
    }
}
