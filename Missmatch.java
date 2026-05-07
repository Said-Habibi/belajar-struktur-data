import java.util.Scanner;
import java.util.InputMismatchException;

public class Missmatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object nim = null;
        boolean inputBenar = false; // Penanda untuk mengontrol loop

        while (!inputBenar) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            try {
                // Baris ini akan melempar error jika input bukan angka
                nim = sc.nextInt(); 
                
                // Jika baris di atas sukses, baris di bawah ini baru dijalankan
                inputBenar = true; 
                System.out.println("NIM diterima!");

            } catch (InputMismatchException e) {
                System.out.println("SAlAH! NIM harus angka. Coba lagi...");
                
                // KRUSIAL: Menghapus input "sampah" agar tidak terjadi infinite loop
                sc.nextLine(); 
                
                // inputBenar tetap false, sehingga while akan mengulang ke atas
            }
        }

        System.out.println("Hasil Akhir NIM: " + nim);
        sc.close();
    }
}
