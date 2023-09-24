package binarysearch;

public class Bounds {

    public static int lowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length-1;
        // the lower bound of the array would be first index where value >= target
        int ind = arr.length;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid]>=target) {
                ind = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ind;
    }

    public static int upperBound(int[] arr,int target) {
        int low = 0;
        int high = arr.length-1;
        int ind = arr.length;
        while (low<=high) {
            int mid = low + (high-low)/2;

            if (arr[mid] > target) {
                ind = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ind;
    }

    public static int searchInsertPosition(int arr[], int tagert) {
        return lowerBound(arr, tagert);
    }
    // while finding the floor of the array we just need to tweak some signs.
    // once that is done then we can simply work on it.
    public static int floor(int arr[],int target) {
        int low = 0;
        int high = arr.length;
        int ans = arr.length;
        while (low <= high) {
            int mid = low+(high-low)/2;

            if (arr[mid]<=target) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static int[] floorAndCeil(int arr[],int target) {
        return new int[]{floor(arr,target),searchInsertPosition(arr,target)};
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 5, 7, 8, 9, 11};
        System.out.println(lowerBound(arr, 12));
        System.out.println(upperBound(arr, 12));
        // searching the insertion position is same as finding out the lower bound of the array.
        System.out.println(floorAndCeil(arr, 8)[0]+" "+floorAndCeil(arr,8)[1]);
    }
}
