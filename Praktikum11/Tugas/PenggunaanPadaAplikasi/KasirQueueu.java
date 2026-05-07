package Praktikum11.Tugas.PenggunaanPadaAplikasi;

public class KasirQueueu {
    private Pelanggan front;
    private Pelanggan rear;
    private int size;

    public KasirQueueu(){
        front = null;
        rear = null;
        size = 0;
    }

    public void datang(String nama, int jumlahItem){
        Pelanggan baru = new Pelanggan(nama, jumlahItem);
        if(isEmpty()){
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        System.out.println("[+] " + nama + " masuk antrian (" + jumlahItem + " item)");
    }

    public void layani(){
        if(isEmpty()){
            System.out.println("Tidak ada pelanggan dalam antrian");
            return;
        }
        int waktu = front.jumlahItem + 1;
        System.out.println("[v] Melayani: " + front.nama + " | " + front.jumlahItem + " item " + " | estimasi waktu: " + waktu + " detik");
        front = front.next;
        if (front == null) rear = null;
        size--;
    }

    public void tampilAntrian(){
        if(isEmpty()){
            System.out.println("Antrian kosong");
            return;
        }
        System.out.print("Antrian saat ini: ");
        Pelanggan cur = front;
        while (cur != null) {
            System.out.print(cur.nama + "(" + cur.jumlahItem+ ")");
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
    public boolean isEmpty(){
        return front == null;
    }

    public int size(){
        return size;
    }
}
