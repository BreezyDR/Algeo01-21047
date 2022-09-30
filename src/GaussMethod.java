public class GaussMethod extends matrixmethods {
    public void gauss(double[][] matrix) {
        int rows = matrix.length;
        int k = 0;
        double x, y;
        double n;

        for (int j = 0; j < rows; j++) {
            for (int i = k+1; i < rows; i++) {
                if ((matrix[k][j] == 0) && (matrix[i][j]) != 0) {
                    switchRow(matrix,k,i);
                }
            }
            k++;
        }
        k = 0;

        for (int j = 0; j < rows; j++) {
            if (searchNonZero(matrix,k) != 0) {
                multiplyRow(matrix, k, 1 / searchNonZero(matrix,k));
                for (int i = k + 1; i < rows; i++) {
                    x = matrix[i][j];
                    y = matrix[k][j];
                    n = x / y;
                    min2barismatrix(matrix, i, k, n);
                }
                k += 1;
            }
        }
    }
}
