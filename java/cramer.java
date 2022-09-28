public class cramer extends matrixmethods {
    public static String[] kaidahCramer(double[][] matrix) {
        int i, j, koefisien;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] A = cutAugmentedToSquare(matrix);
        String[] message = new String[cols - 1];

        double[][] b = new double[rows][1];
        for (i = 0; i < rows; i++) {
            b[i][0] = matrix[i][cols - 1];
        }

        for (koefisien = 0; koefisien < A[0].length; koefisien++) {
            double[][] Abaru = new double[A.length][A[0].length];
            for (i = 0; i < A.length; i++) {
                for (j = 0; j < A[0].length; j++) {
                    if (koefisien == j) {
                        Abaru[i][j] = b[i][0];
                    } else {
                        Abaru[i][j] = matrix[i][j];
                    }
                }
            }
            double x = matrixmethods.determinan(Abaru) / matrixmethods.determinan(A);
            message[koefisien] = "Nilai X" + (koefisien + 1) + "adalah: " + x;
        }
        return message;
    }
}
