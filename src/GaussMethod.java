public class GaussMethod extends matrixmethods {
    public static void gauss(double[][] matrix) {
        // Melakukan operasi OBE pada matrix sehingga diperoleh matriks baris eselon
        int rows = matrix.length;
        int i, j;
        int k = 0;
        double x, y;
        double n;

        // Menukar baris pada matriks sebelum OBE
        while (k < rows) {
            if (searchNonZero(matrix,k) != 0) {
                for (i = k+1; i < rows; i++) {
                    for (j = 0; j <= searchIndex(matrix,k,searchNonZero(matrix,k)); j++) {
                        if ((matrix[k][j] < matrix[i][j]) && (matrix[k][j] == 0)) {
                            switchRow(matrix, i, k);
                        }
                    }
                }
            }
            k += 1;
        }
        k = 0;

        // OBE untuk Metode Gauss
        while (k < rows) {
            if (searchNonZero(matrix,k) != 0) {
                j = searchIndex(matrix,k,searchNonZero(matrix,k));
                multiplyRow(matrix, k, 1 / searchNonZero(matrix,k));
                for (i = k+1; i < rows; i++) {
                    x = matrix[i][j];
                    y = matrix[k][j];
                    n = x / y;
                    min2barismatrix(matrix, i, k, n);
                }
            }
            k += 1;
        }
        k = 0;

        // Menukar baris pada matriks setelah OBE
        while (k < rows) {
            if (searchNonZero(matrix,k) != 0) {
                for (i = k+1; i < rows; i++) {
                    for (j = 0; j <= searchIndex(matrix,k,searchNonZero(matrix,k)); j++) {
                        if ((matrix[k][j] < matrix[i][j]) && (matrix[k][j] == 0)) {
                            switchRow(matrix, i, k);
                        }
                    }
                }
            }
            k += 1;
        }

        // Menghandle angka yang aneh seperti -0
        matrixmethods.epsilonHandler(matrix);
    }
}
