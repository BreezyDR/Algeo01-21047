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
}
