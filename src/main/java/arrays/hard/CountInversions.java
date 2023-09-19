package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {
        int arr[] = new int[]{2,1,2,3,5,6,7,2,3,5};

        int inversions = countInversions_bruteforce(arr,0, arr.length-1);
        System.out.println(inversions);

        inversions = merge_sort(arr,0,arr.length-1);
        System.out.println(inversions);
    }

    private static int merge_sort(int[] arr, int start, int end) {
        if(start>=end) return 0;
        int inv = 0;
        int mid = (start+end)/2;
        inv+=merge_sort(arr,start,mid);
        inv+=merge_sort(arr,mid+1,end);
        inv+=merge(arr,start,mid,end);
        return inv;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        List<Integer> ls = new ArrayList<>();
        int left = start;
        int right = mid+1;
        int cnt = 0;
        while(left<=mid && right<=end) {
            if(arr[left]<=arr[right]) {
                ls.add(arr[left]);
                left++;
            } else {
                cnt += (mid-left+1);
                ls.add(arr[right]);
                right++;
            }
        }

        while(left<=mid) {
            ls.add(arr[left]);
            left++;
        }

        while(right<=end) {
            ls.add(arr[right]);
            right++;
        }

        for(int i=start;i<=end;i++) {
            arr[i] = ls.get(i-start);
        }
        return cnt;
    }

    private static int countInversions_bruteforce(int[] arr,int start,int end) {
        if (start == end) return 0;
        int rem_inv = countInversions_bruteforce(arr,start+1,end);
        int inv = 0;
        for(int i=start+1;i<=end;i++) {
            if (arr[start] > arr[i]) {
                inv++;
            }
        }
        return inv+rem_inv;
    }
}
