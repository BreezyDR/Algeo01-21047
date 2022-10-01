public class main extends menu {
    public static void main(String[] args) {
        int pilihan;
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
            pilihan = pilihanMenu(1, 7);
            switch (pilihan) {
                case 1: // SPL
                    harusSquare = false;
                    matrix = inputDanBuatMatrix(harusSquare);
                    break;
                case 2: // Determinan

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
