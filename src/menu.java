import java.util.*;
import java.io.*;


public class menu extends matrixmethods {
    
    static Scanner scanner = new Scanner(System.in);

    public static int pilihanMenu(int i, int j) {
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

    public static double[][] inputKeyboard(boolean harusSquare) {
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

    public static String inputFilename() {
        boolean isValidFile = false;
        String fileName = null;
        while (!isValidFile) {
            try {
                printlnstr("Masukkan file path dokumen yang akan dibaca:");
                fileName = scanner.nextLine();
                Scanner file = new Scanner(new File(fileName));
                isValidFile = true;
            } catch (FileNotFoundException e) {
                // TODO: handle exception
                printlnstr("File tidak dapat ditemukan! Silakan coba lagi.");
                isValidFile = false;
            }
        }
        return fileName;
    }

    public static double[][] matrixFile(boolean harusSquare) {
        int[] rowandcol = new int[2];
        String file = "";
        double[][] matrix;
        boolean terusinput = true;

        while (terusinput) {
            file = "../test/" + inputFilename();
            rowandcol = filemethods.banyakRowandCol(file);
            if (harusSquare && (rowandcol[0] != rowandcol[1])) {
                printlnstr("Matriks di file tidak berbentuk persegi!");
            } else {
                terusinput = false;
            }
        }
        matrix = filemethods.readMatrixFile(rowandcol[0], rowandcol[1], file);

        return matrix;
    }

    public static double[][] inputDanBuatMatrix(boolean harusSquare) {
        double[][] matrix;
        printlnstr("Menu Input Data Matriks");
        printlnstr("1. Input Keyboard");
        printlnstr("2. Input File");
        int pilihan = pilihanMenu(1, 2);
        if (pilihan == 1) {
            matrix = inputKeyboard(harusSquare);
        } else {
            matrix = matrixFile(harusSquare);
        }
        return matrix;
    }
}
