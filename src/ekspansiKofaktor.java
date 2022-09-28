public class ekspansiKofaktor extends matrixmethods {
    protected double[][] makeNewMatrix (double[][] matrix, int i, int j) {
        /* Membuat matriks baru tanpa elemen pada baris i dan kolom j */
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] mn = new double[rows][cols];
        int k, l;
        int a = 0;
        int b = 0;

        for (k = 0; k < rows; k++) {
            b = 0;
            for (l = 0; l < cols; l++) {
                if (k != i && l != j) {
                    mn[a][b] = matrix[k][l];
                    b += 1;
                }
            }
            if (b == cols) {
                a += 1;
            }
        }
        return mn;
    }

    public double detKofaktor (double[][] matrix) {
        /* Prekondisi: isSquare(m) */
        /* Menghitung nilai determinan m */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j;
        double det = 0;

        if (rows == 2 && cols == 2) {
            det = getElmtDiagonal(matrix,0)*getElmtDiagonal(matrix,1) - matrix[0][1]*matrix[1][0];
        }
        else {
            for (j = 0; j < cols; j++) {
                det += matrix[i][j] * Math.pow((-1),(i+j)) * detKofaktor(makeNewMatrix(matrix,i,j));
            }
        }
        return det;
    }
}