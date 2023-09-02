import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // we will be considering four corners where we will be reading the data.
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        List<Integer> res= new ArrayList<>();
        while(left<=right && top<=bottom) {
            for(int i=left;i<=right;i++) {
                res.add(matrix[top][i]);
                System.out.println("LEFT -> RIGHT "+top+" "+i);
            }
            top++;
            for(int i=top;i<=bottom;i++) {
                res.add(matrix[i][right]);
                System.out.println("TOP -> BOTTOM "+i+" "+right);
            }
            right--;
            // if there is only own row
            // edge case for single row vector.
            if(top<=bottom) {
                for(int i=right;i>=left;i--) {
                    res.add(matrix[bottom][i]);
                    System.out.println("RIGHT -> LEFT "+bottom+" "+i);
                }
                bottom--;
            }
            // Edge cases are for the single column vector
            if(left<=right) {
                for(int i=bottom;i>=top;i--) {
                    res.add(matrix[i][left]);
                    System.out.println("BOTTOM -> TOP "+i+" "+left);
                }
                left++;
            }
        }
        return res;
    }
}