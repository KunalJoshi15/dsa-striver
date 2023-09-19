package arrays.hard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    public int reversePairs_bruteforce(int[] nums) {
        int count = 0;

        for(int i=0;i<nums.length-1;i++) {
            BigInteger curr = BigInteger.valueOf(nums[i]);
            for(int j=i+1;j<nums.length;j++) {
                BigInteger temp = BigInteger.valueOf(nums[j]).multiply(BigInteger.valueOf(2));
                if(curr.compareTo(temp) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reversePairs_optimal(int[] nums) {
        return merge_sort(nums, 0, nums.length-1);
    }

    private int merge_sort(int[] nums, int low,int high) {
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt += merge_sort(nums,low,mid);
        cnt += merge_sort(nums,mid+1,high);
        cnt += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> ls = new ArrayList<>();

        while(left<=mid && right <= high) {
            if(nums[left]<=nums[right]) {
                ls.add(nums[left]);
                left++;
            } else {
                ls.add(nums[right]);
                right++;
            }
        }

        while(left<=mid) {
            ls.add(nums[left]);
            left++;
        }

        while(right<=high) {
            ls.add(nums[right]);
            right++;
        }

        for(int i=low;i<=high;i++) {
            nums[i] = ls.get(i=low);
        }
    }
    // before performing the merge operations we will be counting then number of pairs that we have
    // currently. right = mid+1
    // this is the case because
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid+1;
        int cnt = 0;

        for(int i=low;i<=mid;i++) {
            while(right<=high && nums[i]>2L*nums[right]) {
                right++;
            }
            cnt += (right-mid-1);
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
