import java.util.*;
import java.io.*;

public class regression extends menu {
    public static double[] regression(double[][] matrix) {
        int n = matrix.length;
        int row = matrix[0].length;
        int col = matrix[0].length + 1;
        
        double[][] newmatrix = new double[row][col];
        double[][] elmtaug = new double[n][1];
        for (int i = 0; i < n; i++) {
            elmtaug[i][0] = 1;
        }
        matrix = matrixmethods.increaseMatrix(elmtaug, matrix);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double pass = 0;
                for (int k = 0; k < n; k++) {
                    if (i == 0 && j == 0) {
                        pass += 1;
                    } else if (i == 0) {
                        pass += matrix[k][j];
                    } else if (j == 0) {
                        pass += matrix[k][i];
                    } else {
                        pass += matrix[k][i] * matrix[k][j];
                    }
                }
                newmatrix[i][j] = pass;
            }
        }
        GaussJordanMethod.gaussJordan(newmatrix);

        int y = newmatrix[0].length - 1;
        double[] regresult = new double[y];
        for (int i = 0; i < y; i++) {
            regresult[i] = newmatrix[i][y];
        }

        return regresult;
    }
}
