import java.io.*;
import java.util.*;

public class matrixmethods {
    static Scanner scanner = new Scanner(System.in);

    protected static void print(String str) {
        // Menulis str tanpa newline
        System.out.print(str);
    } 
    protected static void println() {
        // Menulis new line
        System.out.println();
    }
    
    protected static void printlnstr(String str) {
        // Menulis str dengan newline
        System.out.println(str);
    }
    
    protected static void printlndou(double dou) {
        // Menulis str bertipe double denangan new line
        System.out.println(dou);
    }
    
    protected static void printf(String str, Object... args) {
        // Menulis str dengan beberapa format argumen
        System.out.printf(str, args);
    }

    protected static void displayMatrix(double[][] matrix) {
        int i, j;
        int rows = matrix.length;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j] + " ");
            }
            println();
        }
    }

    protected static boolean isSquare(double[][] matrix) {
        return (matrix.length == matrix[0].length);
    }

    protected static double[][] transpose(double[][] matrix) {
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

    protected static double[][] multiplyByConst(double[][] matrix, double x) {
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

    protected static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] mresult = new double[matrix1.length][matrix2[0].length];
        int i, j, k;
        for (i = 0; i < mresult.length; i++) {
            for (j = 0; j < mresult[0].length; j++) {
                mresult[i][j] = 0;
                for (k = 0; k < matrix1[0].length; k++) {
                    mresult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return mresult;
    }

    protected static boolean isZero(double x) {
        double ketelitian = 1.0e-12;
        return ((x < ketelitian) && (x > -ketelitian));
    }

    protected static boolean isRowElmtZero(double[] row) {
        int i;
        for (i = 0; i < row.length; i++) {
            if (!isZero(row[i])) {
                return false;
            }
        }
        return true;
    }
}
