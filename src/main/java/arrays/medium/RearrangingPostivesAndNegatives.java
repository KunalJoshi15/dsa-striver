package arrays.medium;

class RearrangingPostivesAndNegatives {
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] rearrangeArray(int[] nums) {
        int aux[] = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for(int i=0;i<nums.length;i++) {
            if(pos<nums.length && nums[i]>0) {
                aux[pos] = nums[i];
                pos = pos+2;
            } else if(neg<nums.length && nums[i]<0){
                aux[neg] = nums[i];
                neg = neg+2;
            }
        }
        return aux;
    }
    // there can be an extra variety of question that we have for this.
    // if the number of positives or the number of negatives are larger than the other.
    // then we simply have to append those as it is at the end.
}
