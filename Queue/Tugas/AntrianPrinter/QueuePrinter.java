package Tugas.AntrianPrinter;

public class QueuePrinter {

    private String[] antrean;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public QueuePrinter(int size) {

        antrean = new String[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Menambah dokumen ke antrean
    public void tambahPrint(String dokumen) {

        if (isFull()) {
            System.out.println("Antrean printer penuh!");
            return;
        }

        rear = (rear + 1) % capacity;
        antrean[rear] = dokumen;
        count++;

        System.out.println("Dokumen masuk: " + dokumen);
    }

    // Mencetak dokumen
    public String printDokumen() {

        if (isEmpty()) {
            System.out.println("Tidak ada dokumen!");
            return null;
        }

        String data = antrean[front];
        front = (front + 1) % capacity;
        count--;

        return data;
    }

    // Menampilkan antrean
    public void tampilkanAntrean() {

        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return;
        }

        System.out.println("\nDaftar Antrean Printer:");

        for (int i = 0; i < count; i++) {

            int index = (front + i) % capacity;

            System.out.println((i + 1) + ". " + antrean[index]);
        }
    }

    // Mengecek kosong
    public boolean isEmpty() {
        return count == 0;
    }

    // Mengecek penuh
    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {

        QueuePrinter printer = new QueuePrinter(5);

        // Input langsung di kode
        printer.tambahPrint("Laporan.pdf");
        printer.tambahPrint("TugasJava.docx");
        printer.tambahPrint("Foto.png");

        printer.tampilkanAntrean();

        System.out.println("\nMencetak: " + printer.printDokumen());

        printer.tampilkanAntrean();

        System.out.println("\nMencetak: " + printer.printDokumen());

        printer.tampilkanAntrean();
    }
}
