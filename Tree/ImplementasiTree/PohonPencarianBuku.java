package Tree.ImplementasiTree;

public class PohonPencarianBuku {
    private SimpulBuku akar;

    public PohonPencarianBuku() {
        this.akar = null;
    }

    public void tambahBuku(Buku bukuBaru) {
        akar = tambahRekursif(akar, bukuBaru);
    }

    private SimpulBuku tambahRekursif(SimpulBuku simpulSekarang, Buku bukuBaru) {
        if (simpulSekarang == null) {
            return new SimpulBuku(bukuBaru);
        }

        int perbandingan = bukuBaru.getJudul().compareToIgnoreCase(simpulSekarang.buku.getJudul());

        if (perbandingan < 0) {
            simpulSekarang.kiri = tambahRekursif(simpulSekarang.kiri, bukuBaru);
        } else {
            simpulSekarang.kanan = tambahRekursif(simpulSekarang.kanan, bukuBaru);
        }

        return simpulSekarang;
    }

    public Buku cariBuku(String judul) {
        SimpulBuku hasil = cariRekursif(akar, judul);
        return (hasil != null) ? hasil.buku : null;
    }

    private SimpulBuku cariRekursif(SimpulBuku simpulSekarang, String judul) {
        if (simpulSekarang == null || simpulSekarang.buku.getJudul().equalsIgnoreCase(judul)) {
            return simpulSekarang;
        }

        int perbandingan = judul.compareToIgnoreCase(simpulSekarang.buku.getJudul());

        if (perbandingan < 0) {
            return cariRekursif(simpulSekarang.kiri, judul);
        } else {
            return cariRekursif(simpulSekarang.kanan, judul);
        }
    }

    public void tampilkanSemuaBuku() {
        if (apakahKosong()) {
            System.out.println("Perpustakaan masih kosong. Belum ada buku yang terdaftar.");
            return;
        }
        tampilkanInOrder(akar);
    }

    private void tampilkanInOrder(SimpulBuku simpulSekarang) {
        if (simpulSekarang != null) {
            tampilkanInOrder(simpulSekarang.kiri);
            System.out.println("  " + simpulSekarang.buku);
            tampilkanInOrder(simpulSekarang.kanan);
        }
    }

    public int hitungTotalBuku() {
        return hitungTotalRekursif(akar);
    }

    private int hitungTotalRekursif(SimpulBuku simpulSekarang) {
        if (simpulSekarang == null) {
            return 0;
        }
        return 1 + hitungTotalRekursif(simpulSekarang.kiri) + hitungTotalRekursif(simpulSekarang.kanan);
    }

    public boolean apakahKosong() {
        return akar == null;
    }
}
