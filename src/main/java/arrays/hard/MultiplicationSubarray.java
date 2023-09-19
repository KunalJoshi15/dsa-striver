package arrays.hard;

import java.math.*;
class MultiplicationSubarray {
    public int maxProduct(int[] nums) {
        BigInteger prefix = BigInteger.valueOf(1);
        BigInteger suffix = BigInteger.valueOf(1);

        BigInteger max_prod = BigInteger.valueOf(Integer.MIN_VALUE);

        for(int i=0;i<nums.length;i++) {
            if(prefix.equals(BigInteger.ZERO)) prefix = BigInteger.valueOf(1);
            if(suffix.equals(BigInteger.ZERO)) suffix = BigInteger.valueOf(1);

            prefix = prefix.multiply(BigInteger.valueOf(nums[i]));
            suffix = suffix.multiply(BigInteger.valueOf(nums[nums.length-i-1]));
            max_prod = max_prod.max(prefix.max(suffix));
        }

        return max_prod.intValue();
    }

    public static void main(String[] args) {
        MultiplicationSubarray m = new MultiplicationSubarray();
        System.out.println(m.maxProduct(new int[]{2,-1,2,3,5,-5,2,3,-6,22}));
    }
}
