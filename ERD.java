import java.util.ArrayList;
import java.util.List;

// Enum untuk mendefinisikan tipe Kardinalitas
enum Cardinality {
    ONE_TO_ONE("1:1"),
    ONE_TO_MANY("1:N"),
    MANY_TO_ONE("N:1"),
    MANY_TO_MANY("M:N");

    private String label;

    Cardinality(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

// Kelas Relasi untuk menampung tujuan entitas dan tipe kardinalitasnya
class Relation {
    Entity targetEntity;
    Cardinality cardinality;

    public Relation(Entity targetEntity, Cardinality cardinality) {
        this.targetEntity = targetEntity;
        this.cardinality = cardinality;
    }
}

class Entity {
    private String name;
    private List<String> attributes;
    private List<Relation> relations; // Relasi sekarang memiliki tipe kardinalitas

    public Entity(String name) {
        this.name = name;
        this.attributes = new ArrayList<>();
        this.relations = new ArrayList<>();
    }

    public void addAttribute(String attr) {
        this.attributes.add(attr);
    }

    public void addRelation(Entity target, Cardinality type) {
        this.relations.add(new Relation(target, type));
    }

    // ALGORITMA REKURSIF
    public void displayERD(int level) {
        String line = "│   ".repeat(level);

        System.out.println(line + "┌─── [Entitas: " + name.toUpperCase() + "]");
        System.out.println(line + "│    Attributes: " + attributes);

        for (Relation rel : relations) {
            System.out.println(line + "│    (" + rel.cardinality.getLabel() + ") ──┐");
            // Memanggil fungsi secara rekursif untuk entitas tujuan
            rel.targetEntity.displayERD(level + 1);
        }
    }
}

public class ERD {
    public static void main(String[] args) {
        // --- 1. Inisialisasi Entitas ---
        Entity dosen = new Entity("Dosen");
        dosen.addAttribute("123456789");
        dosen.addAttribute("Riko handoko");

        Entity prodi = new Entity("Program_Studi");
        prodi.addAttribute("6789803333");
        prodi.addAttribute("Manajemen informatika");

        Entity mahasiswa = new Entity("Mahasiswa");
        mahasiswa.addAttribute("25030100661");
        mahasiswa.addAttribute("Raihan Ramdani");

        Entity matakuliah = new Entity("Mata_Kuliah");
        matakuliah.addAttribute("03012001");
        matakuliah.addAttribute("4");

        // --- 2. Membangun Relasi dengan Kardinalitas ---

        // One-to-One: Seorang Dosen mengepalai satu Prodi
        dosen.addRelation(prodi, Cardinality.ONE_TO_ONE);

        // One-to-Many: Satu Prodi memiliki banyak Mahasiswa
        prodi.addRelation(mahasiswa, Cardinality.ONE_TO_MANY);

        // Many-to-Many: Banyak Mahasiswa mengambil banyak Mata Kuliah
        mahasiswa.addRelation(matakuliah, Cardinality.MANY_TO_MANY);

        // --- 3. Output ---
        System.out.println("====================================================");
        System.out.println("   VISUALISASI HIERARKI ERD DENGAN KARDINALITAS    ");
        System.out.println("====================================================");
        dosen.displayERD(0);
        System.out.println("====================================================");
    }
}
