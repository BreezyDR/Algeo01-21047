import java.util.*;
import java.io.*;


public class menu extends matrixmethods {
    
    static Scanner scanner = new Scanner(System.in);

    protected static int pilihanMenu(int i, int j) {
        int input = 0;
        printlnstr("Ketikkan angka antara " + i + " dan " + j);
        boolean terusinput = true;
        while (terusinput) {
            input = scanner.nextInt();
            if (input >= i && input <= j) {
                terusinput = false;
            } else {
                printlnstr("Input invalid, ketikkan angka antara " + i + " dan " + j);
            }
        }
        return input;
    }

    private static double[][] inputKeyboard(boolean harusSquare) {
        double[][] matrix;
        int row = 0;
        int col = 0;
        int i, j;
        boolean terusinput = true;
        while (terusinput) {
            if (harusSquare) {
                printlnstr("Silahkan masukkan nilai n dalam dimensi matriks n x n");
                print("--> ");
                row = scanner.nextInt();
                col = row;
            } else {
                printlnstr("Silahkan masukkan nilai m dan n dalam dimensi matriks m x n.");
                print("-->");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }
            if (row > 0 && col > 0) {
                terusinput = false;
            } else {
                printlnstr("Nilai invalid! Silahkan coba lagi.");
            }
        }
        matrix = new double [row][col];

        printlnstr("Masukkan elemen matriks:");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                print("Baris ke-" + (i+1) + " kolom ke-" + (j+1) + ": ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
}
