public class DeterminantRowReduction extends matrixmethods {
    public double detRowReduction(double[][] matrix) {
        /* Prekondisi: isSquare(m) */
        /* Menghitung nilai determinan m menggunakan metode reduksi baris */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i, j;
        int k = 0;
        double x,y;
        double n;
        double p = 0;
        double det = 1;

        // Menukar baris
        for (j = 0; j < rows; j++) {
            for (i = k+1; i < rows; i++) {
                if ((matrix[k][j] == 0) && (matrix[i][j]) != 0) {
                    switchRow(matrix,k,i);
                    p++;
                }
            }
            k++;
        }
        k = 0;

        // Mengubah matriks menjadi matriks segitiga bawah
        for (j = 0; j < cols; j++) {
            for (i = k+1; i < rows; i++) {
                x = matrix[i][j];
                y = matrix[k][j];
                n = x/y;
                min2barismatrix(matrix,i,k,n);
            }
            k += 1;
        }

        // Mengalikan diagonal matriks untuk mencari determinan
        for (i = 0; i < rows; i++) {
            det = Math.pow(-1,p) * det * getElmtDiagonal(matrix,i);
        }
        return (det);
    }
}
