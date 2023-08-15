package arrays;

import java.util.HashMap;
import java.util.Map;

public class SumKSubarray {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        // naive approach to solve thi sproblem will be check the sum for all the subarrays.
        // and then check if some is equal to k.
        // 1 3 6 7 8 9 10
        // O(n) is the time complexity.
        Map<Long,Integer> presumMap = new HashMap();
        long sum = 0;
        int maxLen = 0;
        for(int i=0;i<a.length;i++) {
            sum += a[i];
            if(sum==k) {
                maxLen = Math.max(maxLen,i+1);
            }
            long rem = sum-k;
            if(presumMap.containsKey(rem)) {
                int len = i - presumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            presumMap.putIfAbsent(sum, i);
        }
        return maxLen;
    }
    // if there are only positives present in the array and 0. Then we can even use a two pointer approach.
    public static int longestSubarrayWithSum(int []a,long k) {
        int left = 0;
        int right = 0;
        int sum = a[0];
        int maxLen = 0;
        while(right<a.length) {
            while(left<=right && sum>k) {
                sum = sum-a[left];
                left++;
            }
            if(sum==k) {
                maxLen = Math.max(maxLen,right-left+1);
            }

            right++;
            if(right<a.length) sum = sum+a[right];
        }
        return maxLen;
    }
}
