package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int n = nums.length/3;
        for(Map.Entry<Integer,Integer> x:hm.entrySet()) {
            if(x.getValue()>n) {
                ans.add(x.getKey());
            }
        }
        return ans;
    }

    public List<Integer> majorityElement_optimal(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MAX_VALUE;
        int ele2 = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(cnt1==0 && ele2!=nums[i]) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if(cnt2==0 && ele1!=nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if(nums[i]==ele1) {
                cnt1++;
            } else if(nums[i]==ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;cnt2=0;

        for(int i=0;i<n;i++) {
            if(nums[i]==ele1) {
                cnt1++;
            } else if(nums[i]==ele2) {
                cnt2++;
            }
        }
        if(cnt1>n/3) ans.add(ele1);
        if(cnt2>n/3) ans.add(ele2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}
