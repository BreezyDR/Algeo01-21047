public class Inverse extends EkspansiKofaktor {
    protected double getKofaktor (double[][] matrix,int i, int j) {
        double kof = matrix[i][j] * Math.pow((-1),(i+j)) * detKofaktor(makeNewMatrix(matrix,i,j));
        return kof;
    }

    public double[][] inverse (double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double det = detKofaktor(matrix);
        double[][] matrixInverse = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixInverse[i][j] = getKofaktor(matrix,i,j);
            }
        }
        matrixInverse = transpose(matrixInverse);
        matrixInverse = multiplyByConst(matrixInverse,1/det);
        return matrixInverse;
    }
}
