package arrays.hard;

import java.util.*;

class FourSum {
    // brute force solution to this problem is O(n^4)
    public static List<List<Integer>> fourSum_better(int[] nums,int target) {
        int n = nums.length;

        Set<List<Integer>> hs = new HashSet<>();

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for(int k=j+1;k<n;k++) {
                    int fourth = -1*(nums[i]+nums[j]+nums[k]);
                    if (hashSet.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],fourth);
                        Collections.sort(temp);
                        hs.add(temp);
                    }
                    hashSet.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(hs);
    }

    public static List<List<Integer>> fourSum_optimal(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        System.out.println(fourSum_better(nums,0));
    }
}
