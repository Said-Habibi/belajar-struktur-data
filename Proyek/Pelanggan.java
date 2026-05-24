package Proyek;

public class Pelanggan {
    private String nomorAntrean;
    private String nama;
    private String jenisLayanan;
    private String waktuMasuk;
    public Pelanggan next; // Reference to the next node in the queue

    public Pelanggan(String nomorAntrean, String nama, String jenisLayanan, String waktuMasuk) {
        this.nomorAntrean = nomorAntrean;
        this.nama = nama;
        this.jenisLayanan = jenisLayanan;
        this.waktuMasuk = waktuMasuk;
        this.next = null;
    }

    public String getNomorAntrean() {
        return nomorAntrean;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public String getWaktuMasuk() {
        return waktuMasuk;
    }

    @Override
    public String toString() {
        return "[" + nomorAntrean + "] " + nama + " (" + jenisLayanan + ") - " + waktuMasuk;
    }
}
