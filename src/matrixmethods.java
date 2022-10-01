import java.io.*;
import java.util.*;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.lang.Math;

public class matrixmethods {

    public static void print(String str) {
        // Menulis str tanpa newline
        System.out.print(str);
    } 
    public static void println() {
        // Menulis new line
        System.out.println();
    }
    
    public static void printlnstr(String str) {
        // Menulis str dengan newline
        System.out.println(str);
    }
    
    public static void printlndou(double dou) {
        // Menulis str bertipe double denangan new line
        System.out.println(dou);
    }
    
    public static void printf(String str, Object... args) {
        // Menulis str dengan beberapa format argumen
        System.out.printf(str, args);
    }

    public static void displayMatrix(double[][] matrix) {
        int i, j;
        int rows = matrix.length;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j] + " ");
            }
            println();
        }
    }

    public static boolean isSquare(double[][] matrix) {
        return (matrix.length == matrix[0].length);
    }

    public static double[][] transpose(double[][] matrix) {
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] mresult = new double[cols][rows];
        for (i = 0; i < mresult.length; i++) {
            for (j = 0; j < mresult[i].length; j++) {
                mresult[i][j] = matrix[j][i];
            }
        }
        return mresult;
    }

    public static double[][] multiplyByConst(double[][] matrix, double x) {
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] mresult = new double[rows][cols];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                mresult[i][j] = matrix[i][j] * x;
            }
        }
        return mresult;
    }

    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] mresult = new double[matrix1.length][matrix2[0].length];
        int i, j, k, tempadd;
        for (i = 0; i < mresult.length; i++) {
            for (j = 0; j < mresult[0].length; j++) {
                tempadd = 0;
                for (k = 0; k < matrix1[0].length; k++) {
                    tempadd += matrix1[i][k] * matrix2[k][j];
                }
                mresult[i][j] = tempadd;
            }
        }
        return mresult;
    }

    public static boolean isZero(double x) {
        double ketelitian = 1.0e-10;
        return ((x < ketelitian) && (x > -ketelitian));        
    }

    public static boolean isRowElmtZero(double[] row) {
        int i;
        boolean state = true;
        for (i = 0; i < row.length; i++) {
            if (!isZero(row[i])) {
                state = false;
            }
        }
        return state;
    }

    public static boolean doesMatrixHaveNoSolution(double[][] matrix) {
        boolean state = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (!isZero(matrix[i][j])) {
                    state = false;
                }
            }
            if (isZero(matrix[i][matrix[0].length - 1])) {
                state = false;
            } else {
                state = true;
                break;
            }
        }
        return state;
    }

    public static double[][] cutAugmentedToSquare(double[][] matrix) {
        int i, j;
        double[][] mresult = new double[matrix.length][matrix.length];
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++) {
                mresult[i][j] = matrix[i][j];
            }
        }
        return mresult;
    }

    public static double determinan(double[][] matrix) {
        int i, j, k;
        double[][] kofaktor = new double[matrix.length - 1][matrix[0].length - 1];
        double det = 0;
        int posneg = 1;
        if (matrix.length == 1) {
            det = matrix[0][0];
        } else {
            for (i = 0; i < matrix.length; i++) {
                for (j = 1; j < matrix.length; j++) {
                    for (k = 0; k < matrix[0].length; k++) {
                        if (k < i) {
                            kofaktor[j-1][k] = matrix[j][k];
                        } else if (i < k) {
                            kofaktor[j-1][k-1] = matrix[j][k];
                        }
                    }
                }
            }
            det += posneg * matrix[0][i] * determinan(kofaktor);
            posneg = -posneg;
        }
        return det;
    }

    public static double getElmtDiagonal (double[][] matrix, int i) {
        /* Mengirimkan elemen m(i,i) */
        return (matrix[i][i]);
    }

    public static void min2barismatrix (double[][] matrix, int Row1, int Row2, double n) {
        /* I.S. m terdefinisi dan memiliki jumlah baris minimal 2 */
        /* F.S. ROw1 pada matriks m telah dikurangi n*Row 2 */
        int i;
        for (i = 0; i < matrix[0].length; i++) {
            matrix[Row1][i] = matrix[Row1][i] - n*matrix[Row2][i];
        }
    }

    public static double searchNonZero (double[][] matrix, int row) {
        /* Mengembalikan elemen bukan 0 pertama di row, jika tidak ada maka mengembalikan 0; */
        double val = matrix[row][0];
        boolean found = false;
        int j = 0;

        while ((j < matrix[0].length) && (!found)) {
            if (matrix[row][j] != 0) {
                val = matrix[row][j];
                found = true;
            }
            j++;
        }
        return val;
    }

    public static void multiplyRow (double[][] matrix, int i, double n) {
        /* Mengalikan baris i dengan konstanta n */
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = matrix[i][j]*n;
        }
    }

    public static void switchRow (double[][] matrix, int row1, int row2) {
        /* Menukar row1 dengan row2 */
        double temp;

        for (int j = 0; j < matrix[0].length; j++) {
            temp = matrix[row1][j];
            matrix[row1][j] = matrix[row2][j];
            matrix[row2][j] = temp;
        }
    }

    protected static int searchIndex (double[][] matriks, int row, double n) {
        /* Mencari index kolom dari elemen n pada row */
        boolean found = false;
        int j = 0;
        int index = 0;

        while ((!found) && (j < matriks[0].length)) {
            if (matriks[row][j] == n) {
                found = true;
                index = j;
            }
            j++;
        }
        return index;
    }

    public static void createMatrix (double[][] newMatrix, int m, int n) {
        /* Membuat matrix baru dengan ukuran baris = m dan kolom = n */
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = input.nextInt();
            }
        }
    }
}
