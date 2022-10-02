public class InterpolasiPolinom extends matrixmethods {
    public static double[] polynomialInterpolation(double[][] matrix) {
        int row = matrix.length;
        double[][] matrixProcess = new double[row][row+1];

        for (int i=0; i < row; i++) {
            for (int j=0; j < row + 1; j++) {
                if (j == row) {
                    matrixProcess[i][j] = matrix[i][1];
                } else {
                    matrixProcess[i][j] = (Math.pow(matrix[i][0], j));
                }
            }
        }

        GaussJordanMethod.gaussJordan(matrixProcess);

        double[] solusi = new double[row];
        for (int i=0; i < row; i++) {
            solusi[i] = matrixProcess[i][row];
        }
        return solusi;
    }

    public static double estimateFunction(double[] hasilInterpolasi, double x) {
        int row = hasilInterpolasi.length;
        double estimasi = 0;
        for (int i=0; i<row; i++) {
            estimasi += hasilInterpolasi[i] * Math.pow(x, i);
        }
        return estimasi;
    }
}
