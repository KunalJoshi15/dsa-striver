package arrays.easy;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length*(nums.length+1))/2;

        for(int i=0;i<nums.length;i++) {
            sum = sum-nums[i];
        }
        return sum;
    }
}
