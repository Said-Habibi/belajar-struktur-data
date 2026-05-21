package Search.Squent;

public class Squential {
    public void sequentialSearch(int data[], int cari){
        boolean ditemukan = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != cari){
                System.out.println("Mengakses indeks ke - " + i);
            }
            if (data[i] == cari){
                System.out.println("Data ditemukan pada indeks ke - " + i);
                ditemukan = true;
                break;
            }
        }
            if (ditemukan == false){
            System.out.println("\n[sqeuntial search]");
            System.out.println("data tidak ditemukan");
        }
    }
}
