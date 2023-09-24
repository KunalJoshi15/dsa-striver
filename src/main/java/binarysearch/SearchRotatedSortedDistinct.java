package binarysearch;

public class SearchRotatedSortedDistinct {

    public static int search(int nums[],int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(nums[mid]==target) return mid;

            if(nums[low] <= nums[mid]) {
                // this means that the left half is sorted.
                if(nums[low] <= target && target<=nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                // Right part of the array is sorted.
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
        System.out.println(search);
    }
}
