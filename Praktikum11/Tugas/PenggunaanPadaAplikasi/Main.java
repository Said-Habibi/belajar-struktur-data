package Praktikum11.Tugas.PenggunaanPadaAplikasi;

public class Main {
    public static void main(String[] args) {
        KasirQueueu kasir = new KasirQueueu();
        System.out.println("=== Simulasi Kasir Supermarket ===\n");

        kasir.datang("Budi", 5);
        kasir.datang("Ani", 3);
        kasir.datang("Doni", 8);
        kasir.datang("Sari", 2);

        System.out.println("\nJumlah antrian: " + kasir.size());
        kasir.tampilAntrian();

        System.out.println("\n--- Kasir mulai melayani ---");
        kasir.layani();
        kasir.layani();

        System.out.println();
        kasir.tampilAntrian();

        System.out.println("\n--- Pelanggan baru datang ---");
        kasir.datang("Rina", 4);
        kasir.tampilAntrian();
        System.out.println("\n--- Kasit melayani semua sisa ---");
        while(!kasir.isEmpty()){
            kasir.layani();
        }
        System.out.println("\n--- Semua pelanggan telah dilayani ---");
    }
}
