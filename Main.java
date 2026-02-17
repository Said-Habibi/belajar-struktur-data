import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        boolean nimSukses = false;
        boolean nilaiSukses = false;
        Object nim = null;
        Object nilai = null;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan Nama Mahasiswa: ");
        String namaMahasiswa = sc.nextLine();

        while (!nimSukses){
            try {
                System.out.print("Masukan NIM Mahasiswa: ");
                nim = sc.nextInt();

                nimSukses = true;   
            } catch (InputMismatchException e) {
                System.out.println("Masukan nim dengan benar");
                nim = sc.nextLine(); // hapus buffer
            }
        } 


        System.out.print("Masukan Fakultas Mahasiswa: ");
        String fakultas = sc.nextLine();
        fakultas = sc.nextLine();
        
        System.out.print("Masukan Jurusan Mahasiswa: ");
        String jurusan = sc.nextLine();
        
        System.out.print("Masukan Prodi Mahasiswa: ");
        String prodi = sc.nextLine();
        
        System.out.print("Masukan Universitas Mahasiswa: ");
        String universitas = sc.nextLine();
        
        System.out.print("Masukan Nama Mata Kuliah: ");
        String matkul = sc.nextLine();
        
        while (!nilaiSukses){
            try {
                System.out.print("Masukan Nilai Mahasiswa: ");
                nilai = sc.nextInt();

                nilaiSukses = true;
            } catch (InputMismatchException e) {
                System.out.println("Nilai Tidak Berupa Angka mohon masukan ulang anjay");
                nilai = sc.nextLine(); // hapus buffer
            }
        }
        int intNilai = (nilai != null) ? 0 : (int) nilai;
        String variableNilai = cekNilai(intNilai);
        
        sc.close();  
        
        System.out.println("===== Data Mahasiswa =====");
        System.out.println("Nama Mahasiswa: "+ namaMahasiswa);
        System.out.println("NIM Mahasiswa: "+ nim);
        System.out.println("Nama Mahasiswa: "+ fakultas);
        System.out.println("Nama Mahasiswa: "+ jurusan);
        System.out.println("Nama Mahasiswa: "+ prodi);
        System.out.println("Universitas: "+universitas);
        System.out.println();
        System.out.println("===== Hasil Belajar =====");
        System.out.println("Nama Mahasiswa: "+ matkul);
        System.out.println("Nilai Mahasiswa: "+nilai);
        System.out.println("Variable Nilai Mahasiswa: "+variableNilai);
        
          
    }  
    static String cekNilai(int nilai){
        if (nilai >= 75){
            return "A";
        }
        else if (nilai >= 65){
            return "B";
        } 
        else if (nilai >= 55){
            return "C";
        } else {
            return "D";
        }
    }
}  