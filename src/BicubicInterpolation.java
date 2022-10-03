public class BicubicInterpolation extends matrixmethods {
    protected static double[][] change16 (double[][] matrix) {
        // Membuat matriks baru dari elemen matrix dengan ukuran 16x1
        int k = 0;
        double[][] newMatrix = new double[16][1];

        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[k][0] = doubles[j];
                k++;
            }
        }
        return newMatrix;
    }

    protected static double koefisien_aij (double x, double y, int i, int j) {
        // Menghitung koefisien aij
        return (Math.pow(x,i) * Math.pow(y,j));
    }

    protected static double modelSigma (double[][] matrix, double x, double y) {
        // Menghitung interpolasi dengan model sigma
        double res = 0;
        int i = 0;
        int j = 0;

        for (double[] doubles : matrix) {
            res += koefisien_aij(x, y, i, j) * doubles[0];
            if (i == 3) {
                i = 0;
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    protected static double[][] matrix_X () {
        // Membuat matrix X
        double[][] matrix = new double[16][16];
        int rows = 16;
        int cols = 16;
        double x = -1;
        double y = -1;
        int i, j;

        for (int a = 0; a < rows; a++) {
            i = 0;
            j = 0;
            for (int b = 0; b < cols; b++) {
                matrix[a][b] = koefisien_aij(x,y,i,j);
                if (i == 3) {
                    i = 0;
                    j++;
                }
                else {
                    i++;
                }
            }
            if (x == 2) {
                x = -1;
                y++;
            }
            else {
                x++;
            }
        }
        return matrix;
    }

    public static double bicubicInterpolation (double[][] matrix, double x, double y) {
        double[][] matrix16 = change16(matrix);
        double[][] matrixX = matrix_X();
        double[][] inverse_matrixX = Inverse.inverseGaussJordan(matrixX);
        double[][] matrix_a = multiplyMatrix(inverse_matrixX,matrix16);
        return (modelSigma(matrix_a,x,y));
    }
}
