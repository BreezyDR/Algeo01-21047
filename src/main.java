public class main extends menu {
    public static void main(String[] args) {
        double determinan;
        boolean sedangrunning, selesai, harusSquare;
        double[][] matrix;

        sedangrunning = true;
        while (sedangrunning) {
            selesai = false;
            printlnstr("MENU UTAMA");
            printlnstr("1. Sistem Persamaan Linear");
            printlnstr("2. Determinan");
            printlnstr("3. Matriks balikan");
            printlnstr("4. Interpolasi Polinom");
            printlnstr("5. Interpolasi Bicubic");
            printlnstr("6. Regresi Linier Berganda");
            printlnstr("7. Keluar");
            int pilihan = pilihanMenu(1, 7);
            switch (pilihan) {
                case 1: // SPL
                    harusSquare = false;
                    matrix = inputDanBuatMatrix(harusSquare);
                    String[] outputSPL = new String[matrix[0].length];
                    double det1 = 0;
                    double[][] matrixSPL;
                    if (matrix.length == matrix[0].length - 1) {
                        det1 = determinan(matrix);
                    }
                    boolean terusinput = true;
                    while (terusinput) {
                        printlnstr("Menu Sistem Persamaan Linear");
                        printlnstr("1. Metode eliminasi Gauss");
                        printlnstr("2. Metode eliminasi Gauss-Jordan");
                        printlnstr("3. Metode matriks balikan");
                        printlnstr("4. Kaidah Cramer");
                        pilihan = pilihanMenu(1, 4);
                        if (pilihan == 1 || pilihan == 2 || !isZero(det1)) {
                            terusinput = false;
                        } else {
                            if (pilihan == 3) {
                                printlnstr("SPL tidak bisa diperoleh dengan matriks balikan. Silahkan pilih metode lain\n");
                            } else {
                                printlnstr("SPL tidak bisa diperoleh dengan kaidah Cramer. Silahkan pilih metode lain\n");
                                
                            }
                        }
                    }
                    printlnstr("Matriks SPL yang diperoleh:\n");
                    switch (pilihan) {
                        case 1:
                            GaussMethod.gauss(matrix);
                            matrixSPL = copyMatrix(matrix);
                            displayMatrix(matrixSPL);
                            outputSPL = SPL.SPLGauss(matrixSPL, true);
                            break;
                        case 2:
                            GaussJordanMethod.gaussJordan(matrix);
                            matrixSPL = copyMatrix(matrix);
                            displayMatrix(matrixSPL);
                            outputSPL = SPL.SPLGauss(matrixSPL, false);
                            break;
                        case 3:
                            outputSPL = SPL.SPLInvers(matrix);
                            break;
                        case 4:
                            outputSPL = cramer.kaidahCramer(matrix);
                            break;
                    }
                    printlnstr("Solusi SPL adalah:");
                    SPL.displaySPL(outputSPL);
                    printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                    printlnstr("1. Ya");
                    printlnstr("2. Tidak");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        while (!selesai) {
                            printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                            String directory = scanner.next();
                            selesai = filemethods.writeSPLkeFile("../test/" + directory, outputSPL);
                        }
                    }
                    break;
                case 2: // Determinan
                    harusSquare = true;
                    matrix = inputDanBuatMatrix(harusSquare);
                    printlnstr("Menu Determinan");
                    printlnstr("1. Metode Row Reduction");
                    printlnstr("2. Metode ekspansi kofaktor");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        determinan = DeterminantRowReduction.detRowReduction(matrix);
                    } else {
                        determinan = determinan(matrix);
                    }
                    break;
                case 3: // Matriks balikan

                    break;  
                case 4: // Interpolasi polinom

                    break;    
                case 5: // Interpolasi Bicubic

                    break;    
                case 6: // Regresi linier berganda

                    break;       
                default: // Keluar
                printlnstr("Terima kasih sudah menggunakan kalkulator kami!\nSemoga kita berjumpa lagi.");
                sedangrunning = false;
                    break;
            }
            println();
        }
    }
}
