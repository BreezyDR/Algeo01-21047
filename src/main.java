import java.io.FileWriter;

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
                    printlnstr("Matriks SPL yang diperoleh:");
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
                    printlnstr("Determinan matriks");
                    displayMatrix(matrix);
                    print("\nadalah ");
                    printlndou(determinan);
                    printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                    printlnstr("1. Ya");
                    printlnstr("2. Tidak");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        while (!selesai) {
                            printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                            String directory = scanner.next();
                            selesai = filemethods.writeMatrixDeterminankeFile("../test/" + directory, matrix, determinan);
                        }
                    }
                    break;
                case 3: // Matriks balikan
                    harusSquare = true;
                    matrix = inputDanBuatMatrix(harusSquare);
                    printlnstr("Menu Inverse");
                    printlnstr("1. Metode eliminasi Gauss-Jordan");
                    printlnstr("2. Metode matriks kofaktor");
                    pilihan = pilihanMenu(1, 2);
                    if (isZero(determinan(matrix))) {
                        printlnstr("Matriks");
                        displayMatrix(matrix);
                        printlnstr("\nTidak memiliki invers karena determinan = 0");
                        printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                        printlnstr("1. Ya");
                        printlnstr("2. Tidak");
                        pilihan = pilihanMenu(1, 2);
                        if (pilihan == 1) {
                            while (!selesai) {
                                printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                                String directory = scanner.next();
                                selesai = filemethods.writeMatrixInversekeFile("../test/" + directory, matrix, matrix, false);
                            }
                        }
                    } else {
                        double[][] matrixInvers = new double[matrix.length][matrix[0].length];
                        if (pilihan == 1) {
                            matrixInvers = Inverse.inverseGaussJordan(matrix);
                        } else {
                            matrixInvers = Inverse.inverseCofactor(matrix);
                        }
                        printlnstr("Invers matriks");
                        displayMatrix(matrix);
                        printlnstr("\nadalah");
                        displayMatrix(matrixInvers);
                        printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                        printlnstr("1. Ya");
                        printlnstr("2. Tidak");
                        pilihan = pilihanMenu(1, 2);
                        if (pilihan == 1) {
                            while (!selesai) {
                                printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                                String directory = scanner.next();
                                selesai = filemethods.writeMatrixInversekeFile("../test/" + directory, matrix, matrixInvers, true);
                            }
                        }
                    }
                    break;  
                case 4: // Interpolasi polinom
                    harusSquare = false;
                    matrix = inputDanBuatMatrix(harusSquare);
                    double[] solusiInterpolasi = InterpolasiPolinom.polynomialInterpolation(matrix);
                    print("Masukkan nilai yang akan ditaksir: ");
                    double nilai = scanner.nextDouble();
                    double estimasi = InterpolasiPolinom.estimateFunction(solusiInterpolasi, nilai);
                    printf("Nilai taksiran fungsi saat x = %f adalah ", nilai);
                    printlndou(estimasi);
                    printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                    printlnstr("1. Ya");
                    printlnstr("2. Tidak");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        while (!selesai) {
                            printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                            String directory = scanner.next();
                            selesai = filemethods.writeInterpolasikeFile("../test/" + directory, solusiInterpolasi, nilai, estimasi);
                        }
                    }
                    break;    
                case 5: // Interpolasi Bicubic

                    break;    
                case 6: // Regresi linier berganda
                    int varamount, equationamount;
                    printlnstr("Pilih: 1. Masukan dari keyboard; 2. Masukan dari file");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        print("Masukkan banyak variabel x: ");
                        varamount = scanner.nextInt();
                        print("Masukkan banyak persamaan: ");
                        equationamount = scanner.nextInt();
                        printf("Masukkan %d persamaan\n", equationamount);
                        matrix = new double[varamount][equationamount];
                        double[] y = new double[varamount];
                        for (int i=0; i < varamount; i++) {
                            for (int j=0; j < equationamount; j++) {
                                matrix[i][j] = scanner.nextDouble();
                            }
                            y[i] = scanner.nextDouble();
                        }
                    } else {
                        double[][] dariFile = matrixFile(false);
                        matrix = new double[dariFile.length][dariFile[0].length - 1];
                        for (int i=0; i < matrix.length; i++) {
                            for (int j=0; j < matrix[i].length; j++) {
                                matrix[i][j] = dariFile[i][j];
                            }
                        }
                    }

                    double[] regresiresult = regression.regression(matrix);

                    printlnstr("\nPersamaan regresi linear berganda adalah:");
                    printf("y = %f", regresiresult[0]);
                    for (int i=1; i < regresiresult.length; i++) {
                        if (regresiresult[i] > 0) {
                            printf(" + %f x%d", regresiresult[i], i);
                        } else {
                            printf(" %f x%d", regresiresult[i], i);
                        }
                    }
                    printf("\nUntuk menaksir nilai fungsi, masukkan %d peubah yang akan ditaksir nilai fungsinya.", regresiresult.length - 1);
                    double[] arraytaksir = new double[regresiresult.length];
                    for (int i=0; i < regresiresult.length - 1; i++) {
                        arraytaksir[i] = scanner.nextDouble();
                    }
                    double hasiltaksir = regresiresult[0];
                    for (int i=0; i < regresiresult.length - 1; i++) {
                        hasiltaksir += regresiresult[i+1] * arraytaksir[i];
                    }
                    printf("\nNilai taksiran adalah %f\n", hasiltaksir);

                    printlnstr("Apakah Anda ingin menulis hasil ke dalam file?");
                    printlnstr("1. Ya");
                    printlnstr("2. Tidak");
                    pilihan = pilihanMenu(1, 2);
                    if (pilihan == 1) {
                        while (!selesai) {
                            try {
                                printlnstr("Masukkan directory file yang ingin dituliskan hasilnya:");
                                String directory = scanner.next();
                                FileWriter writer = new FileWriter("../test/" + directory);
                                writer.write("Persamaan regresi linear berganda adalah\ny= ");
                                writer.write(Double.toString(regresiresult[0]));
                                for (int i=1; i < regresiresult.length; i++) {
                                    if (regresiresult[i] > 0) {
                                        writer.write(" + ");
                                    }
                                    writer.write(Double.toString(regresiresult[i]));
                                    writer.write("x");
                                    writer.write(Integer.toString(i));
                                }
                                writer.write("\nNilai taksirannya adalah ");
                                writer.write(Double.toString(hasiltaksir));
                                writer.write("\n");
                                writer.close();
                                printlnstr("Hasil sudah dituliskan kepada file.");
                                selesai = true;
                            } catch (Exception e) {
                                // TODO: handle exception
                                printlnstr("Something went wrong, try again.");
                            }
                        }
                    }
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
