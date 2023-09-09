package arrays.hard;

import java.util.HashMap;

public class ZeroSumSubarray {

    public static void main(String[] args) {
        int arr[] = new int[]{-1,1,0,-2,3,-1};
        int ans = findZeroSumSubarray(arr);
        System.out.println(ans);
    }

    private static int findZeroSumSubarray(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int prefix_sum = 0;
        int maxi = 0;
        for (int i=0;i<arr.length;i++) {
            prefix_sum += arr[i];
            if(prefix_sum==0) {
                maxi = i+1;
            }
            if(hm.containsKey(prefix_sum)) {
                maxi = Math.max(maxi, i-hm.get(prefix_sum));
            }
            else {
                // we are inserting only when the prefix_sum is encounter first time.
                // not using the closest one because it won't contribute to the longest prefix sum.
                hm.put(prefix_sum, i);
            }
        }
        return maxi;
    }
}
