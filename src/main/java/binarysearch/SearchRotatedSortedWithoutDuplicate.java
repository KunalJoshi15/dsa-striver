package binarysearch;

public class SearchRotatedSortedWithoutDuplicate {

    public static void main(String[] args) {
        int search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
        System.out.println(search);
    }

    private static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]==target) return mid;

            if (arr[mid]==arr[low] && arr[mid]==arr[high]) {
                low++;
                high--;
                continue;
            }

            if(arr[low] <= arr[mid]) {
                // left part is sorted
                if(arr[low]<=target && target<=arr[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                // Right half is sorted
                if (arr[mid]<=target && arr[high]<=target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
