package arrays.hard;

import java.util.HashMap;

public class MaxmumXorK {

    public static void main(String[] args) {
        int arr[] = new int[]{4,2,2,4,6,2,2};
        int ans = findMaximumXor(arr,6);
        System.out.println(ans);
    }

    private static int findMaximumXor(int[] arr,int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int prefix_xor = 0;
        hm.put(0,1);
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            prefix_xor = prefix_xor^arr[i];
            int x = prefix_xor^target;
            count += hm.getOrDefault(prefix_xor,0);
            hm.put(prefix_xor, hm.getOrDefault(prefix_xor, 0)+1);
        }
        return count;
    }
}
