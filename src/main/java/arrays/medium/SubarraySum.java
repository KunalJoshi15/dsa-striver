package arrays.medium;

import java.util.HashMap;

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // the array with sum 0 is 1.
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int j=0;j<nums.length;j++) {
            sum += nums[j];
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
