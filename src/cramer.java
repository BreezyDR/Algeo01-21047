public class cramer extends matrixmethods {
    public static String[] kaidahCramer(double[][] matrix) {
        // Menerapkan metode Cramer pada matrix dan mengembalikan SPL-nya berupa array of strings
        // yang berisi nilai X1, X2, ... Xn.
        // Metode cramer menggunakan Ax = b.
        int i, j, koefisien;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Menginisialisasi matriks A dari Ax = b
        double[][] A = cutAugmentedToSquare(matrix); // Matrix masih berbentuk augmented sehingga perlu dipotong
        String[] message = new String[cols - 1];

        // Menginisialisasi matriks b dari Ax = b
        double[][] b = new double[rows][1];
        for (i = 0; i < rows; i++) {
            b[i][0] = matrix[i][cols - 1];
        }

        // Menghitung nilai x
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
            // Menghitung nilai Xn menggunakan rumus determinan(Abaru) / determinan(A)
            double x = EkspansiKofaktor.detKofaktor(Abaru) / EkspansiKofaktor.detKofaktor(A);
            message[koefisien] = "Nilai X" + (koefisien + 1) + " adalah: " + x;
        }
        return message;
    }
}
