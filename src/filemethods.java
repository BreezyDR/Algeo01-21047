import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class filemethods extends matrixmethods {
    public static double[][] readMatrixFile(int row, int col, String file) {
        double[][] matrix = new double[row][col];

        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            printlnstr("File tidak dapat ditemukan! Silakan coba lagi.");
        }

        Scanner scanmatrix = new Scanner(reader);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double elmt = scanmatrix.nextDouble();
                matrix[i][j] = elmt;
            }
        }
        scanmatrix.close();
        return matrix;
    }

    public static int[] banyakRowandCol(String file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            printlnstr("File tidak dapat ditemukan! Silakan coba lagi.");
        }

        int row = 0;
        int col = 0;
        String stringrow = "";
        Scanner rowscanner = new Scanner(reader);
        while (rowscanner.hasNextLine()) {
            row++;
            stringrow = rowscanner.nextLine();
        }
        Scanner colscanner = new Scanner(stringrow);
        while (colscanner.hasNextDouble()) {
            col++;
            colscanner.nextDouble();
        }
        rowscanner.close();
        colscanner.close();

        int[] rowandcol = new int[2];
        rowandcol[0] = row;
        rowandcol[1] = col;
        return rowandcol;        
    }

    public static boolean writeMatrixkeFile(String directory, double[][] matrix) {
        try {
            FileWriter writer = new FileWriter(directory);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(Double.toString(matrix[i][j]) + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");
            writer.close();
            printlnstr("Hasil sudah dituliskan kepada file.");
            return true;
        } catch (IOException e) {
            // TODO: handle exception
            printlnstr("Something went wrong. Try again");
            return false;
        }
    }

    public static boolean writeSPLkeFile(String directory, String[] SPL) {
        try {
            FileWriter writer = new FileWriter(directory);
            for (int i=0; i < SPL.length; i++) {
                writer.write(SPL[i] + "\n");
            }
            writer.write("\n");
            writer.close();
            printlnstr("Hasil sudah dituliskan kepada file.");
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            printlnstr("Something went wrong. Try again");
            return false;
        }
    }

    public static boolean writeMatrixDeterminankeFile(String directory, double[][] matrix, double det) {
        try {
            FileWriter writer = new FileWriter(directory);
            writer.write("Determinan matriks berikut \n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(Double.toString(matrix[i][j]) + " ");
                }
                writer.write("\n");
            }
            writer.write("\nadalah");
            writer.write(Double.toString(det));
            writer.write("\n");
            writer.close();
            printlnstr("Hasil sudah dituliskan kepada file.");
            return true;
        } catch (IOException e) {
            // TODO: handle exception
            printlnstr("Something went wrong. Try again");
            return false;
        }
    }

    public static boolean writeMatrixInversekeFile(String directory, double[][] matrix, double[][] inverse, boolean hasInverse) {
        try {
            FileWriter writer = new FileWriter(directory);
            if (hasInverse) {
                writer.write("Invers matriks berikut \n");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        writer.write(Double.toString(matrix[i][j]) + " ");
                    }
                    writer.write("\n");
                }
                writer.write("\nadalah");
                for (int i = 0; i < inverse.length; i++) {
                    for (int j = 0; j < inverse[i].length; j++) {
                        writer.write(Double.toString(inverse[i][j]) + " ");
                    }
                    writer.write("\n");
                }
            } else {
                writer.write("Matriks berikut \n");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        writer.write(Double.toString(matrix[i][j]) + " ");
                    }
                    writer.write("\n");
                }
                writer.write("\nTidak memiliki invers.");
            }
            writer.write("\n");
            writer.close();
            printlnstr("Hasil sudah dituliskan kepada file.");
            return true;
        } catch (IOException e) {
            // TODO: handle exception
            printlnstr("Something went wrong. Try again");
            return false;
        }
    }
    
    public static boolean writeRegresikeFile(String directory, double[] hasilregresi, double taksiran) {
        try {
            FileWriter writer = new FileWriter(directory);
            writer.write("Persamaan regresi linear berganda adalah: ");
            writer.write(Double.toString(hasilregresi[0]));
            for (int i = 1; i < hasilregresi.length; i++) {
                if (hasilregresi[i] > 0) {
                    writer.write(" + ");
                }
                writer.write(Double.toString(hasilregresi[i]));
                writer.write("x");
                writer.write(Integer.toString(i));
            }
            writer.write("\nJadi nilai taksirannya: ");
            writer.write(Double.toString(taksiran));
            writer.write("\n");
            writer.close();
            printlnstr("Hasil sudah dituliskan kepada file.");
            return true;
        } catch (IOException e) {
            // TODO: handle exception
            printlnstr("Something went wrong. Try again");
            return false;
        }
    }
}
