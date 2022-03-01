import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[][] mat = new int[][]{{0,1,1},{1,1,1},{1,1,1}};

        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(matrix[i], 10000);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (mat[r][c] == 0) {
                    matrix[r][c] = 0;
                } else {
                    if (r > 0) {
                        matrix[r][c] = Math.min(matrix[r][c], matrix[r-1][c] + 1);
                    }
                    if (c > 0) {
                        matrix[r][c] = Math.min(matrix[r][c], matrix[r][c-1] + 1);
                    }
                }
            }
        }

        for (int r = mat.length - 1; r >= 0; r--) {
            for (int c = mat[0].length - 1; c >= 0; c--) {
                if (r != m - 1) {
                    matrix[r][c] = Math.min(mat[r][c], mat[r+1][c] + 1);
                }
                if (c != n - 1) {
                    matrix[r][c] = Math.min(matrix[r][c], matrix[r][c+1] + 1);
                }
            }
        }

        return matrix;
    }
}
