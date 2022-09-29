public class DeterminantRowReduction extends matrixmethods {
    protected void min2barismatrix (double[][] matrix, int Row1, int Row2, double n) {
        /* I.S. m terdefinisi dan memiliki jumlah baris minimal 2 */
        /* F.S. ROw1 pada matriks m telah dikurangi n*Row 2 */
        int i;
        for (i = 0; i < matrix[0].length; i++) {
            matrix[Row1][i] = matrix[Row1][i] - n*matrix[Row2][i];
        }
    }

    public double detRowReduction(double[][] matrix) {
        /* Prekondisi: isSquare(m) */
        /* Menghitung nilai determinan m */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i, j;
        int k = 0;
        double x,y;
        double n = 0;
        double det = 1;

        for (j = 0; j < rows; j++) {
            for (i = k+1; i < cols; i++) {
                x = matrix[i][j];
                y = matrix[k][j];
                n = x/y;
                min2barismatrix(matrix,i,k,n);
            }
            k += 1;
        }
        for (i = 0; i < rows; i++) {
            det = det * getElmtDiagonal(matrix,i);
        }
        return (det);
    }
}
