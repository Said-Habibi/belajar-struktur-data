package Tree.ImplementasiTree;

public class SimpulBuku {
    Buku buku;
    SimpulBuku kiri;
    SimpulBuku kanan;

    public SimpulBuku(Buku buku) {
        this.buku = buku;
        this.kiri = null;
        this.kanan = null;
    }
}
