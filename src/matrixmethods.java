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
        // Menampilkan matriks
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
        // Mengembalikan true jika matrix berupa persegi
        return (matrix.length == matrix[0].length);
    }

    public static double[][] transpose(double[][] matrix) {
        // Mengembalikan transpose dari matrix
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
        // Mengembalikan matrix yang semua elemennya sudah dikalikan suatu konstanta
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
        // Mengembalikan matriks hasil perkalian matrix1 dan matrix2
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
        // Mengembalikan true jika x bernilai nol dengan ketelitian 10 angka di belakang koma
        double ketelitian = 1.0e-10;
        return ((x < ketelitian) && (x > -ketelitian));        
    }

    public static boolean isRowElmtZero(double[] row) {
        // Mengembalikan true jika sebuah row (dalam hal ini sebuah array of double) semuanya bernilai nol
        int i;
        boolean state = true;
        for (i = 0; i < row.length; i++) {
            if (!isZero(row[i])) {
                state = false;
            }
        }
        return state;
    }

    public static boolean isColElmtZero(double[][] matrix, int col) {
        // Mengembalikan true jika sebuah col dalam matrix semuanya bernilai nol
        boolean state = true;
        for (int i = 0; i < matrix.length; i++) {
            if (!isZero(matrix[i][col])) {
                state = false;
            }
        }
        return state;
    }

    public static boolean doesMatrixHaveNoSolution(double[][] matrix) {
        // Mengembalikan true jika matriks tidak memiliki solusi
        for (int i = 0; i < matrix.length; i++) {
            if (checkRowZeroUntilLast(matrix[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRowZeroUntilLast(double[] row) {
        // Mengembalikan true jika sebuah row memiliki semua elemennya 0 kecuali elemen terakhir
        for (int i = 0; i < row.length - 1; i++) {
            if (!isZero(row[i])) {
                return false;
            }
        }
        if (!isZero(row[row.length-1])) {
            return true;
        } else {
            return false;
        }
    }

    public static double[][] cutAugmentedToSquare(double[][] matrix) {
        // Mengembalikan matriks yang sudah dipotong kolomnya sebanyak 1 dari bentuk augmentednya
        int i, j;
        double[][] mresult = new double[matrix.length][matrix.length];
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++) {
                mresult[i][j] = matrix[i][j];
            }
        }
        return mresult;
    }

    public static double[][] cutRowAllZero(double[][] matrix) {
        // Mengembalikan matriks yang sudah dipotong barisnya yang semua elemennya nol
        int rowallzero = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (isRowElmtZero(matrix[i])) {
                rowallzero++;
            }
        }
        if (rowallzero == 0) {
            return matrix;
        } else {
            int newrow = matrix.length - rowallzero;
            int newcol = matrix[0].length;
            double[][] newmatrix = new double [newrow][newcol];
            
            for (int i = 0; i < newrow; i++) {
                for (int j = 0; j < newcol; j++) {
                    newmatrix[i][j] = matrix[i][j];
                }
            }
            return newmatrix;
        }
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

    public static double[][] increaseMatrix(double[][] matrix1, double[][] matrix2) {
        // Memperluas matriks dengan menggabungkan matrix1 dan matrix2
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        double[][] hasilmatrix = new double[rows1][cols1+cols2];
        for (int i= 0; i < hasilmatrix.length; i++) {
            for (int j = 0; j < hasilmatrix[0].length; j++) {
                if (j < cols1) {
                    hasilmatrix[i][j] = matrix1[i][j];
                } else {
                    hasilmatrix[i][j] = matrix2[i][j-cols1];
                }
            }
        }
        return hasilmatrix;
    }

    public static double[][] copyMatrix(double[][] MIn) {
        // Mengembalikan matriks yang merupakan duplikat MIn
        int i, j;
        double[][] MOut = new double[MIn.length][MIn[0].length];
        for (i = 0; i < MIn.length; i++) {
            for (j = 0; j < MIn[0].length; j++) {
                MOut[i][j] = MIn[i][j];
            }
        }
        return MOut;
    }

    public static void epsilonHandler (double[][] matrix) {
        /* Mengahandle angka kecil dan -0 */
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 1e-9 && matrix[i][j] > -1e-9) {
                    matrix[i][j] = Math.abs(matrix[i][j]);
                }
            }
        }
    }
}
