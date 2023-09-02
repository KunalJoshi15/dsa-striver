package arrays.medium;

class RotateNinety {
    // this is the brute force approach.. find the indices whether the
    // values will be present in the resultant array and then place them at those positions accordingly
    public void rotate(int[][] matrix) {
        // we can do this by using a separate array
        int x[][] = new int[matrix.length][matrix[0].length];
        int row = matrix.length;
        int col = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                x[j][(row-1)-i] = matrix[i][j];
            }
        }

        for(int i=0;i<x.length;i++) {
            for(int j=0;j<x.length;j++) {
                matrix[i][j] = x[i][j];
            }
        }
        // 00->02 01 -> 12 02 -> 22 10 ->
    }
    // the other way to approach this particular problem is to firstly reverse the array and then transpose the array
    public void rotate_optimal(int [][]matrix) {
        matrix_reversal(matrix);
        transpose(matrix);
        printArray(matrix);
    }

    public void printArray(int [][]matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void matrix_reversal(int [][]matrix) {
        for(int i=0;i<matrix.length;i++) {
            int a = 0;
            int b = matrix.length-1;
            while (a<=b) {
                int temp = matrix[a][i];
                matrix[a][i] = matrix[b][i];
                matrix[b][i] = temp;
                a++;
                b--;
            }
        }
    }

    private void transpose(int [][]matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=i+1;j<matrix.length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateNinety rotateNinety = new RotateNinety();
        rotateNinety.rotate_optimal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});;
    }
}
