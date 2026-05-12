package Tugas.RumahSakit;

public class QueueRumahSakit {

    private String[] antreanPasien;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public QueueRumahSakit(int size) {

        antreanPasien = new String[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Menambah pasien ke antrean
    public void tambahPasien(String nama) {

        if (isFull()) {
            System.out.println("Antrean pasien penuh!");
            return;
        }

        rear = (rear + 1) % capacity;
        antreanPasien[rear] = nama;
        count++;

        System.out.println("Pasien masuk: " + nama);
    }

    // Memanggil pasien
    public String panggilPasien() {

        if (isEmpty()) {
            System.out.println("Tidak ada pasien!");
            return null;
        }

        String pasien = antreanPasien[front];

        front = (front + 1) % capacity;
        count--;

        return pasien;
    }

    // Menampilkan antrean pasien
    public void tampilkanAntrean() {

        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return;
        }

        System.out.println("\nDaftar Antrean Pasien:");

        for (int i = 0; i < count; i++) {

            int index = (front + i) % capacity;

            System.out.println((i + 1) + ". " + antreanPasien[index]);
        }
    }

    // Mengecek antrean kosong
    public boolean isEmpty() {
        return count == 0;
    }

    // Mengecek antrean penuh
    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {

        QueueRumahSakit rs = new QueueRumahSakit(5);

        // Input langsung di kode
        rs.tambahPasien("Andi");
        rs.tambahPasien("Budi");
        rs.tambahPasien("Sinta");

        rs.tampilkanAntrean();

        System.out.println("\nPasien dipanggil: " + rs.panggilPasien());

        rs.tampilkanAntrean();

        System.out.println("\nPasien dipanggil: " + rs.panggilPasien());

        rs.tampilkanAntrean();
    }
}