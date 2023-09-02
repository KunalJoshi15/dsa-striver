package arrays.easy;

class SingleAppearance {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones = Integer.MIN_VALUE;
        int cons_ones = 0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                cons_ones++;
            } else {
                cons_ones = 0;
            }
            max_ones = Math.max(max_ones,cons_ones);
        }
        return max_ones;
    }
}
