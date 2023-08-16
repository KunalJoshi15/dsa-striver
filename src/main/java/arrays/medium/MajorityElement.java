package arrays.medium;

public class MajorityElement {
    public static int majorityElement(int []v) {
        // Write your code here
        int candidate = -1;
        int count = 0;
        int start = 0;
        while(start<v.length) {
            if(count==0) {
                candidate = v[start];
                count = 1;
            } else {
                if(candidate==v[start]) count++;
                else count--;
            }
            start++;
        }
        count = 0;
        for (int index = 0; index < v.length; index++) {
            if (v[index] == candidate)
                count++;
        }
        if (count > (v.length / 2))
            return candidate;
        return -1;
    }
}
