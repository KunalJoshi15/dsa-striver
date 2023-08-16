package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int ans[] = new int[2];
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<end;i++) {
            int curr = nums[i];

            if(hm.containsKey(target-curr)==true) {
                ans[0] = hm.get(target-curr);
                ans[1] = i;
                break;
            }
            hm.put(curr,i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = new int[]{2,1,2,3,5,6,8};
        TwoSum twoSum = new TwoSum();
        // will give us the indexes that will provide us the two sum.
        Arrays.stream(twoSum.twoSum(nums,5))
                .forEach(System.out::println);
    }
}
