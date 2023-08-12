package hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public static void main(String[] args) {
        int arr[] = {10,5,10,15,10,5};
        int n = arr.length;
        Frequency(arr,n);
    }

    private static void Frequency(int[] arr, int n) {
        HashMap<Integer,Integer> um = new HashMap<>();

        for (int x:arr) {
            um.put(x,um.getOrDefault(x,0)+1);
        }

        int maxFreq = 0, maxEle = 0;
        int minFreq = n, minEle = 0;

        for(Map.Entry<Integer,Integer> val : um.entrySet()) {
            int element = val.getKey();
            int count = val.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxEle = element;
            }
            if (count < minFreq) {
                minFreq = count;
                minEle = element;
            }
        }
        System.out.println("The highest frequency element is: "+maxEle);
        System.out.print("The lowest frequency element is: "+minEle);
    }
}
