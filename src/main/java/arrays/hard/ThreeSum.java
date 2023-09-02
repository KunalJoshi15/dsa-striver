package arrays.hard;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threesum_brute(List<Integer> ls) {
        int n = ls.size();

        Set<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++) {
                    if(i<n && j<n && k<n && ls.get(i)+ls.get(j)+ls.get(k)==0) {
                        List<Integer> temp = Arrays.asList(ls.get(i), ls.get(j), ls.get(k));
                        Collections.sort(temp);
                        hs.add(temp);
                    }
                }
            }
        }

        extracted(hs, lists);
        return lists;
    }

    private static void extracted(Set<List<Integer>> hs, List<List<Integer>> lists) {
        Iterator iterator = hs.iterator();
        while (iterator.hasNext()) {
            lists.add((List<Integer>) iterator.next());
        }
    }

    public static List<List<Integer>> threesum_better(List<Integer> ls) {
        int n = ls.size();

        Set<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=i+1;j<n;j++) {
                if(j<n) {
                    int third = -1 * (ls.get(i) + ls.get(j));
                    if(hashSet.contains(third)) {
                        List<Integer> integerList = Arrays.asList(ls.get(i), ls.get(j), third);
                        Collections.sort(integerList);
                        hs.add(integerList);
                    }
                    hashSet.add(ls.get(j));
                }
            }
        }
        extracted(hs,ans);
        return ans;
    }
    // the most optimal solution in this case would be to use the two pointer approach in order to find the three elements.
    // The time complexity for this solution will be O(n^2)
    public static List<List<Integer>> threesum_optimal(List<Integer> ls) {
        Collections.sort(ls);

        List<List<Integer>> ans = new ArrayList<>();
        int n = ls.size();
        for (int i=0;i<n;i++) {
            if(i>0 && ls.get(i)==ls.get(i-1)) continue;
            int j = i+1;
            int k = n-1;

            while(j<k) {
                int sum = ls.get(i)+ls.get(j)+ls.get(k);

                if(sum==0) {
                    List<Integer> integerList = Arrays.asList(ls.get(i),ls.get(j),ls.get(k));
                    Collections.sort(integerList);
                    ans.add(integerList);
                    j++;
                    k--;

                    while (k<j && ls.get(j)==ls.get(j-1)) j++;

                    while(k<j && ls.get(k)==ls.get(k+1)) k--;
                } else if(sum<0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threesum_optimal(Arrays.asList(13,-18,-1,-44,-48,-9,-16,-36,-13,29,17,-12,9,-49)));
    }
}