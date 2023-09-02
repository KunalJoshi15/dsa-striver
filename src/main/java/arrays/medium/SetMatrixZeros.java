package arrays.medium;

import java.util.Arrays;

class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];

        for(int i=0;i<m;i++) {
            row[i] = 1;
        }

        for(int j=0;j<n;j++) {
            cols[j] = 1;
        }

        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    row[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(row[i]==0 || cols[j]==0) {
                    matrix[i][j] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int arr[][] = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setMatrixZeros.setZeroes(arr);

        Arrays.stream(arr)
                .flatMapToInt(e->Arrays.stream(e))
                .forEach(System.out::println);
    }
}
