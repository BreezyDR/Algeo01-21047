import java.io.*;
import java.util.*;

import javax.lang.model.element.Element;

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

    protected static boolean isZero(double x) {
        double ketelitian = 1.0e-10;
        return ((x < ketelitian) && (x > -ketelitian));        
    }

    protected static boolean isRowElmtZero(double[] row) {
        int i;
        boolean state = true;
        for (i = 0; i < row.length; i++) {
            if (!isZero(row[i])) {
                state = false;
            }
        }
        return state;
    }

    protected static boolean doesMatrixHaveNoSolution(double[][] matrix) {
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

    protected static double[][] cutAugmentedToSquare(double[][] matrix) {
        int i, j;
        double[][] mresult = new double[matrix.length][matrix.length];
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++) {
                mresult[i][j] = matrix[i][j];
            }
        }
        return mresult;
    }

    protected static double determinan(double[][] matrix) {
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
}