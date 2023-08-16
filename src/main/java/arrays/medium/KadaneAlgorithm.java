package arrays.medium;

class KadaneAlgorithm {
    public int maxSubArray(int[] arr) {
        int max_sum = arr[0];
        int current_sum = 0;
        int start = -1;
        int aStart = 0;
        int aEnd = 0;
        for(int i=0;i<arr.length;i++) {
            if(current_sum==0) {
                start = i;
            }
            current_sum += arr[i];
            if(max_sum<current_sum) {
                max_sum = current_sum;
                aStart = start;
                aEnd = i;
            }
            if(current_sum<0) {
                current_sum = 0;
            }
        }
        // the subarray with the maximum sum would be now aStart till aEnd
        return max_sum;
    }
}