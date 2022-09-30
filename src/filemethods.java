import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class filemethods extends matrixmethods {
    public static double[][] bacaMatriksFile(int row, int col, String file) {
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
}
