package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,1,1,2,2,3,4,5,6,7,7,7);
        removeDuplicates(integerList);

    }

    private static void removeDuplicates(List<Integer> integerList) {
        // we can insert all the elments to a set and then get everything from set to a list.
        int j = 0;
        for(int i=1;i<integerList.size();i++) {
            if (integerList.get(i)!=integerList.get(j)) {
                j++;
                integerList.set(j,integerList.get(i));
            }
        }
        // return j+1; -> this will precisely be the size of the array which there.
    }
}
