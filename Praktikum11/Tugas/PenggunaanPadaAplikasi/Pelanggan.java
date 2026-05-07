package Praktikum11.Tugas.PenggunaanPadaAplikasi;

public class Pelanggan {
    String nama;
    int jumlahItem;
    Pelanggan next;

    public Pelanggan(String nama, int jumlahItem){
        this.nama = nama;
        this.jumlahItem = jumlahItem;
        this.next = null;
    }
}
