public class SPL extends matrixmethods {
    public static int leadingone(double[][] matrix, int col) {
        // Mengembalikan indeks baris jika terdapat leading one di suatu kolom.
        // Jika tidak ada, dikembalikan -1.
        boolean terusScan = true;
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (!isZero(matrix[i][col]) && (!isZero(matrix[i][col] - 1))) {
                return -1;
            }
            if (isZero(matrix[i][col] - 1)) {
                if (terusScan) {
                    index = i;
                    terusScan = false;
                } else {
                    return -1;
                }
            }
        }
        return index;
    }

    public static char variableMachine(int index, int[] arrayIndex, int count) {
        // Mengembalikan suatu variabel dimulai dari 'a', 'b', dst.
        char variable = 'a';
        for (int i=0; i < count; i++) {
            if (arrayIndex[i] == index) {
                variable = (char) (((int) variable) + i);
                return variable;
            }
        }
        return 'X';
    }

    public static String[] parametersolving(double[][] matrix, boolean dariGauss) {
        // Mengembalikan array of string yang mengandung SPL dalam bentuk parametrik
        int row = matrix.length;
        int col = matrix[0].length;
        String[] hasil = new String[col - 1];

        if (dariGauss) {
            GaussJordanMethod.gaussJordan(matrix);
        }

        int count = 0;
        int[] varArray = new int[col - 1];
        for (int i = 0; i < col -1; i++) {
            if (leadingone(matrix, i) == -1) {
                varArray[count] = i;
                count++;
            }
        }

        for (int i = 0; i < col - 1; i++) {
            String solusi = "";
            int indexRow = leadingone(matrix, i);
            if (indexRow != -1) {
                solusi += ("x" + (i + 1) + " = " + matrix[indexRow][col-1]);
                for (int j = (i+1); j < col - 1; j++) {
                    double value = matrix[indexRow][j];
                    if (!isZero(value)) {
                        solusi += (" + (" + (-value) + ")" + variableMachine(j, varArray, count));
                    }
                }
            } else {
                solusi += "x" + (i + 1) + " = " + variableMachine(i, varArray, count);
            }
            hasil[i] = solusi;
        }
        return hasil;
    }

    public static String[] SPLGauss(double[][] matrix, boolean apaGaussJordan) {
        // Mengembalikan array of string yang mengandung SPL
        // Jika apaGaussJordan = true, mengembalikan SPL dengan metode Gauss Jordan
        // Jika apaGaussJordan = false, mengmbalikan SPL dengan metode Gauss
        int row = matrix.length;
        int col = matrix[0].length;

        if (doesMatrixHaveNoSolution(matrix)) {
            // Matriks tidak ada solusi
            String[] hasil = { "Tidak ada solusi" };
            return hasil;
        } else {
            double[][] matrixEff = cutRowAllZero(matrix);
            row = matrixEff.length;
            try {
                col = matrixEff[0].length;
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
                col = 0;
            }
            if (row == (col - 1)) {
                if (!apaGaussJordan) {
                    String[] Firstcase = new String[col-1];
                    double[] storage = new double[col-1];
                    for (int a=row-1; a>=0; a--) {
                        storage[a] = matrixEff[a][col-1];
                        for (int b=col-2; b > a; b--) {
                            storage[a] -= matrixEff[a][b] * storage[b];
                        }
                        Firstcase[a] = "x" + (a + 1) + " = " + storage[a];
                    }
                    return Firstcase;
                } else {
                    String[] Secondcase = new String[row];
                    for (int c = 0; c < row; c++) {
                        Secondcase[c] = "x" + (c + 1) + " = " + matrixEff[c][col-1];
                    }
                    return Secondcase;
                }
            } else if (row < (col-1)) {
                return parametersolving(matrixEff, true);
            } else {
                // row > col - 1
                String[] hasil = { "Tidak ada solusi "};
                return hasil;
            }
        }
    }

    public static String[] SPLInvers(double[][] matrix) {
        // Mengembalikan array of string berisi SPL dari invers
        int row = matrix.length;
        int col = matrix[0].length;
        double[][] matrix2 = new double[row][1];
        String[] hasil = new String[row+1];
        for (int i=0; i<row; i++) {
            matrix2[i][0] = matrix[i][col-1];
        }
        double[][] hasilSPL = multiplyMatrix(Inverse.inverseCofactor(cutAugmentedToSquare(matrix)), matrix2);

        hasil[0] = "Solusi SPL menggunakan matriks invers adalah:";
        for (int i=0; i < row; i++) {
            hasil[i+1] = "x" + (i+1) + " = " + hasilSPL[i][0]; 
        }
        return hasil;
    }

    public static void displaySPL(String[] SPL) {
        // Memperlihatkan hasil SPL dari array of string SPL
        for (int i = 0; i < SPL.length; i++) {
            printlnstr(SPL[i]);
        }
    }
}
