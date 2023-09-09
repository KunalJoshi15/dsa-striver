package arrays.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingAndRepeating {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,1,2,3,5,6,7);
        printMissingAndRepeating_bruteForce(integerList);
        printMissingAndRepeatingHashing(integerList);
        printMissingAndRepeatingUsingMathematics(integerList);
        printMissingAndRepeatingUsingBitManipulation(integerList);
    }

    private static void printMissingAndRepeatingUsingBitManipulation(List<Integer> integerList) {
        int total_xor = 0;
        for (int i=0;i<integerList.size();i++) {
            total_xor = total_xor^integerList.get(i);
            total_xor = total_xor^(i+1);
        }

        int bitNo = 0;
        while(true) {
            if((total_xor & (1<<bitNo))!=0) {
                break;
            }
            bitNo++;
        }
        int zero = 0;
        int one = 0;

        for(int i=0;i<integerList.size();i++) {
            if ((integerList.get(i) & (1<<bitNo))!=0) {
                one = one^integerList.get(i);
            } else {
                zero = zero^integerList.get(i);
            }
        }
        int count = 0;

        for (int i=0;i<integerList.size();i++) {
            if (integerList.get(i)==zero) {
                count++;
            }
        }
        int missing = count == 0 ? zero : one;
        int repeating = count != 0 ? zero : one;

        System.out.println("missing: "+missing+" repeating: "+repeating);
    }

    private static void printMissingAndRepeatingUsingMathematics(List<Integer> integerList) {
        int n = integerList.size();
        long sumN = ((long) n *(n+1))/2;
        long sum2N = (n*(2L *n+1)*(n+1))/6;
        long sum = 0;
        long sum2 = 0;

        for (int i=0;i<n;i++) {
            sum += integerList.get(i);
            sum2 += (long) integerList.get(i)*integerList.get(i);
        }
        long eq1 = sum-sumN;
        long eq2 = sum2-sum2N;
        eq2 = eq2 / eq1;

        long repeating = (eq1+eq2)/2;
        long missing = repeating-eq1;

        System.out.println("missing: "+missing+" repeating: "+repeating);
    }

    private static void printMissingAndRepeatingHashing(List<Integer> integerList) {
        // the other better solution that we can implement uses the concept of hashing. O(n) time complexity and O(n) space complexity.
        int missing = -1,repeating = -1;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for (int num : integerList) {
            hm.put(num,hm.getOrDefault(num, 0)+1);
        }

        for (int i=1;i<=integerList.size();i++) {
            if (hm.getOrDefault(i, 0)==2) {
                repeating = i;
            } else if (hm.getOrDefault(i, 0)==0) {
                missing = i;
            }
        }
        System.out.println("repeating: "+repeating+" missing: "+missing);
    }

    private static void printMissingAndRepeating_bruteForce(List<Integer> integerList) {
        // this is a brute force solution with time complexity of O(n^2) and space complexity of O(1)
        int missing = -1;
        int repeating = -1;

        for (int i=1;i<=integerList.size();i++) {
            int count = 0;
            for (int j=0;j<integerList.size();j++) {
                if (integerList.get(j)==i) {
                    count++;
                }
            }
            if (count==2) repeating = i;
            if (count==0) missing = i;

            if (repeating!=-1 && missing!=-1) break;
        }
        System.out.println("missing: "+missing+" repeating: "+repeating);
    }
}
