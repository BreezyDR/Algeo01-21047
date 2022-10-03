public class Inverse extends EkspansiKofaktor {
    protected static double getKofaktor (double[][] matrix, int i, int j) {
        // Mendapatkan kofaktor dari matrix dengan format Cij.
        return Math.pow((-1),(i+j)) * detKofaktor(makeNewMatrix(matrix,i,j));
    }

    public static double[][] inverseCofactor (double[][] matrix) {
        // Mengembalikan inverse matriks menggunakan metode ekspansi kofaktor
        int rows = matrix.length;
        int cols = matrix[0].length;
        double det = detKofaktor(matrix);
        double[][] matrixInverse = new double[rows][cols];

        // Inverse matriks 2x2
        if (rows == 2 && cols == 2) {
            matrixInverse[0][0] = matrix[1][1];
            matrixInverse[1][1] = matrix[0][0];
            matrixInverse[0][1] = -matrix[0][1];
            matrixInverse[1][0] = -matrix[1][0];
        }
        // Inverse matriks ukuran lebih dari 2x2
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixInverse[i][j] = getKofaktor(matrix, i, j);
                }
            }
            matrixInverse = transpose(matrixInverse);
        }
        matrixInverse = multiplyByConst(matrixInverse,1/det);

        // Menghandle angka yang aneh seperti -0
        matrixmethods.epsilonHandler(matrixInverse);

        return matrixInverse;
    }

    public static double[][] inverseGaussJordan(double[][] matrix) {
        // Mengembalikan matriks balikan dengan metode Gauss Jordan
        int row = matrix.length;
        int col = matrix[0].length;
        // Menginisialisasi matriks dengan format [matrix | I]
        double[][] temp = new double[row][2*col];

        for (int i=0; i < temp.length; i++) {
            for (int j=0; j < temp[0].length; j++) {
                if (j < col) {
                    temp[i][j] = matrix[i][j];
                } else {
                    if ((j - col) == i) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }
        }
        GaussJordanMethod.gaussJordan(temp);
        double[][] matrixGaussJordan = copyMatrix(temp);
        double[][] hasilInverse = new double[row][col];

        for (int i=0; i < hasilInverse.length; i++) {
            for (int j=0; j < hasilInverse[i].length; j++) {
                hasilInverse[i][j] = matrixGaussJordan[i][j+col];
            }
        }
        return hasilInverse;
    }
}
