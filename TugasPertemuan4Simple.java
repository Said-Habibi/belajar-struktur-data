import java.util.ArrayList;

//  ENUM KARDINALITAS
enum Kardinalitas {
    ONE_TO_ONE("1:1"),
    ONE_TO_MANY("1:N"),
    MANY_TO_MANY("M:N");

    private String label;

    Kardinalitas(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

// CLASS RELASI
class Relasi {
    private Entitas target;
    private Kardinalitas tipe;

    public Relasi(Entitas target, Kardinalitas tipe) {
        this.target = target;
        this.tipe = tipe;
    }

    // Getter & Setter
    public Entitas getTarget() {
        return target;
    }

    public void setTarget(Entitas target) {
        this.target = target;
    }

    public Kardinalitas getTipe() {
        return tipe;
    }

    public void setTipe(Kardinalitas tipe) {
        this.tipe = tipe;
    }
}

// CLASS ENTITAS
class Entitas {
    private String nama;
    private ArrayList<String> atribut;
    private ArrayList<Relasi> relasi;

    public Entitas(String nama) {
        this.nama = nama;
        this.atribut = new ArrayList<>();
        this.relasi = new ArrayList<>();
    }

    // Getter & Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<String> getAtribut() {
        return atribut;
    }

    public void setAtribut(ArrayList<String> a) {
        this.atribut = a;
    }

    public ArrayList<Relasi> getRelasi() {
        return relasi;
    }

    public void setRelasi(ArrayList<Relasi> r) {
        this.relasi = r;
    }

    public void tambahAtribut(String attr) {
        this.atribut.add(attr);
    }

    public void tambahRelasi(Entitas target, Kardinalitas tipe) {
        this.relasi.add(new Relasi(target, tipe));
    }

    // REKURSIF: Tampilkan ERD secara hierarki
    public void tampilkanRekursif(int level) {
        String garis = "│   ".repeat(level);

        System.out.println(garis + "┌─── [" + nama + "]");

        // Tampilkan atribut secara rekursif
        tampilAtributRekursif(0, garis);

        // Tampilkan relasi & lanjut ke entitas berikutnya (rekursif)
        for (Relasi r : relasi) {
            System.out.println(garis + "│    ── (" + r.getTipe().getLabel() + ") ──>");
            r.getTarget().tampilkanRekursif(level + 1);
        }

        System.out.println(garis + "└────────────");
    }

    // REKURSIF: Tampilkan atribut satu per satu
    private void tampilAtributRekursif(int index, String garis) {
        if (index >= atribut.size())
            return;

        System.out.println(garis + "│    - " + atribut.get(index));

        tampilAtributRekursif(index + 1, garis);
    }
}

// MAIN CLASS
public class TugasPertemuan4Simple {
    public static void main(String[] args) {

        // Buat Entitas
        Entitas mahasiswa = new Entitas("Mahasiswa");
        mahasiswa.tambahAtribut("NIM: 101");
        mahasiswa.tambahAtribut("Nama: Said Habibi");

        Entitas ktm = new Entitas("KTM");
        ktm.tambahAtribut("No KTM: KTM-101");
        ktm.tambahAtribut("Berlaku: 2025-2029");

        Entitas prodi = new Entitas("Prodi");
        prodi.tambahAtribut("Kode: TI-01");
        prodi.tambahAtribut("Nama: Teknik Informatika");

        Entitas mataKuliah = new Entitas("Mata Kuliah");
        mataKuliah.tambahAtribut("Kode: MK01");
        mataKuliah.tambahAtribut("Nama: Struktur Data");
        mataKuliah.tambahAtribut("SKS: 3");

        // 1:1 -> 1 Mahasiswa punya 1 KTM
        mahasiswa.tambahRelasi(ktm, Kardinalitas.ONE_TO_ONE);

        // 1:N -> 1 Prodi punya banyak Mahasiswa
        prodi.tambahRelasi(mahasiswa, Kardinalitas.ONE_TO_MANY);

        // M:N -> Banyak Mahasiswa ambil banyak MataKuliah
        mahasiswa.tambahRelasi(mataKuliah, Kardinalitas.MANY_TO_MANY);

        // Demo Getter & Setter
        System.out.println("=== Demo Getter & Setter ===");
        System.out.println("Sebelum: " + mahasiswa.getAtribut());
        mahasiswa.getAtribut().set(1, "Nama: Said (Updated)");
        System.out.println("Sesudah: " + mahasiswa.getAtribut());

        // Tampilkan ERD (Rekursif)
        System.out.println("\n=== VISUALISASI ERD (Rekursif) ===");
        System.out.println("Dari sudut pandang Prodi:\n");
        prodi.tampilkanRekursif(0);
    }
}
