package Praktikum11.Program2;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);

        System.out.println("Element depan: " + q.getFront());
        System.out.println("Element belakang: " + q.getRear());
        System.out.println("Ukuran antrean: " + q.size());

        System.out.println("Dikeluarkan: " + q.deQueue());
        System.out.println("apakah kosong? " + q.isEmpty());
    }
}
