package arrays.hard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // there are three types of questions that can be asked with pascal triangle.

    // 1) Given R and C tell the element that is present in that place R=5 and C-3
    // ans = 6
    // 2) Print a particular row from the pascal triangle.
    // 3) Print the entire pascal triangle

    static BigDecimal findNCR(int n, int r) {
        BigDecimal ans = BigDecimal.ONE;

        for(int i=0;i<r;i++) {
            ans = ans.multiply(BigDecimal.valueOf(n-i));
            ans = ans.divide(BigDecimal.valueOf(i+1));
        }
        return ans;
    }

    private static void print_triangle_1() {
        // we will be using permutation and combinations in order to compute.
        // 10C3 will simply be (10*9*8)/(3*2*1)
        // we will be simply running a loop till n.
        // for any cases where the factorials are being used we usually take the datastructure as long long.
        int rows = 10;
        int cols = 5;
        System.out.print(findNCR(rows-1,cols-1)+" ");
    }

    private static void print_traingle_2() {
        // Brute force solution
        int n = 5;
        for(int cols = 1;cols<=n;cols++) {
            System.out.print(findNCR(n-1,cols-1)+" ");
        }
    }

    // we can have a slight observation while printing the values.
    // it is basically
    private static List<Integer> print_triangle_2_optimal(int row) {
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        int ans = 1;

        for(int i=1;i<row;i++) {
            ans = ans*(row-i);
            ans = ans/(i);
            ansRow.add(ans);
        }
        return ansRow;
    }

    private static void print_triangle_3() {
        int n = 6;

        for(int i=1;i<=6;i++) {
            System.out.println(print_triangle_2_optimal(i));
        }
    }

    public static void main(String[] args) {
        print_triangle_1();
        System.out.println();
        print_traingle_2();
        System.out.println();
        System.out.println(print_triangle_2_optimal(3));
        print_triangle_3();
    }


}
