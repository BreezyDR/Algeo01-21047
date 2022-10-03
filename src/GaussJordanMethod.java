public class GaussJordanMethod extends matrixmethods {
    public static void gaussJordan(double[][] matrix) {
        // Melakukan operasi OBE pada matrix sehingga diperoleh matriks baris eselon tereduksi
        int rows = matrix.length;
        int i, j;
        int k;
        double x, y;
        double n;

        // Fase maju (forward phase) atau fase eliminasi gauss
        GaussMethod.gauss(matrix);

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

        // Menghandle angka yang aneh seperti -0
        matrixmethods.epsilonHandler(matrix);
    }
}
