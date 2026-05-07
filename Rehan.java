import java.util.Scanner;
import java.util.InputMismatchException;
public class Rehan {
    public static void main(String[] args){
        Object nilai = null;
        boolean sukses = false;

        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Masukan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        Object NIM = null;

        while (!sukses){
            try {
                System.out.print("Masukan NIM Mahasiswa: ");
                NIM = scanner.nextInt();

                sukses = true;
            } catch (InputMismatchException e) {
                System.out.println("Masukan NIM Dengan Benar!!");

                NIM = scanner.nextLine();
            }
        }

        System.out.print("Masukan Nama Mata Kuliah: ");
        String matkul = scanner.nextLine();
        matkul = scanner.nextLine();

         sukses = false;

         while (!sukses){
            try {
                System.out.print("Masukan Nilai Mahasiswa: ");
                nilai = scanner.nextInt();

                sukses = true;
            } catch (InputMismatchException e) {
                System.out.println("Yang Anda Masukan Bukan Angka!!!");
                nilai = scanner.nextLine();
            }
        }

        scanner.close();

        int variabelNilai = (nilai != null) ? (int) nilai : 0;
        
        System.out.println("----- Hasil Penilaian -----");
        System.out.println("Nama Mahasiswa: "+nama);
        System.out.println("Nomor Induk Mahasiswa: "+NIM);
        System.out.println("Mata Kuliah: "+matkul);
        System.out.println("Nilai Mahasiswa: "+nilai);
        System.out.println("Variabel Nilai: "+cekVariabel(variabelNilai));
    }
    static String cekVariabel(int nilai){
        if (nilai >= 80){
            return "A";
        } else if (nilai >= 70){
            return "B";
        } else if (nilai >= 60){
            return "C";
        } else {
            return "D";
        }
    }
}
