package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    // the most naive solution that comes to our mind when thinking about the leaders is...
    // we need to pick up the leaders when iterating from the left side we will check if it is
    // larger than any other elements that are present in the array.
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        int n = a.length;
        List<Integer> leaders = new ArrayList<>();
        leaders.add(a[n-1]);
        int max_ele = a[n-1];
        for(int i=n-2;i>=0;i--) {
            if(a[i]>max_ele) {
                leaders.add(a[i]);
            }
            max_ele = Math.max(max_ele, a[i]);
        }
        return leaders;
    }

    public static void main(String[] args) {
        List<Integer> integerList = superiorElements(new int[]{23, 2, 1, 22, 3, 4, 5, 5});
        integerList.stream()
                .forEach(System.out::println);
    }
}
