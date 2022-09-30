public class GaussJordanMethod extends matrixmethods {
    public void gaussJordan(double[][] matrix) {
        int rows = matrix.length;
        int i, j;
        int k;
        double x, y;
        double n;

        // Fase maju (forward phase) atau fase eliminasi gauss
        GaussMethod faseMaju = new GaussMethod();
        faseMaju.gauss(matrix);

        // Fase mundur (backward phase)
        for (i = 0; i < rows - 1; i++) {
            for (k = i + 1; k < rows; k++) {
                j = searchIndex(matrix, k, searchNonZero(matrix, k));
                x = matrix[i][j];
                y = matrix[k][j];
                if (y != 0) {
                    n = x / y;
                    min2barismatrix(matrix, i, k, n);
                }
            }
        }
    }
}
