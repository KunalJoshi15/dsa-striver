package arrays.hard;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int arr[][] = {
                {1, 3}, {2, 6}, {8, 10}, {15, 16}
        };
        int ans[][] = findOverlappingIntervals_bruteforce(arr);
        Arrays.stream(ans)
                .forEach(ele->{
                    System.out.println(ele[0]+" "+ele[1]);
                });
    }

    private static int[][] findOverlappingIntervals_bruteforce(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0]!=o2[0]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(!ls.isEmpty() && ls.get(ls.size()-1).get(1)>=end) {
                continue;
            }

            for(int j=i+1;j<arr.length;j++) {
                if(arr[j][0]<=end) {
                    end = Math.max(end, arr[j][0]);
                } else {
                    break;
                }
            }
            ls.add(Arrays.asList(start,end));
        }
        int[][] ans = new int[ls.size()][2];
        ListIterator<List<Integer>> listListIterator = ls.listIterator();
        int i = 0;
        while(listListIterator.hasNext()) {
            ans[i][0] = listListIterator.next().get(0);
            ans[i][1] = listListIterator.next().get(1);
            i++;
        }
        return ans;
    }

    public static List<List<Integer>> findMergedIntervals_optimized(int intervals[][]) {
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(ans.isEmpty() || (ans.get(ans.size()-1).get(1)<intervals[i][0])) {
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            } else {
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]));
            }
        }
        return ans;
    }
}
