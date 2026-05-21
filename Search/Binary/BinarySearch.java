package Search.Binary;
    public class BinarySearch {
    public void binarySearch(int[] data, int cari) {
        int awal = 0;
        int akhir = data.length - 1;
        boolean ditemukan = false;

        System.out.println("\n[Binary Search]");

        while (awal <= akhir) {
            int tengah = (awal + akhir) / 2;

            System.out.println("Mengakses indeks ke-" + tengah + " dengan data " + data[tengah]);

            if (data[tengah] == cari) {
                System.out.println("Data ditemukan pada indeks ke-" + tengah);
                ditemukan = true;
                break;
            } else if (cari < data[tengah]) {
                akhir = tengah - 1;
            } else {
                awal = tengah + 1;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
