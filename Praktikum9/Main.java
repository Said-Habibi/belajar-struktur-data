package Praktikum9;

public class Main {
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        SingleLinkedList sll = new SingleLinkedList();
        Node data1 = new Node("Ardi");
        Node data3 = new Node("Keenan");
        Node data2 = new Node("Vita");
        sll.addFirst(data1);
        sll.addFirst(data2);
        sll.addFirst(data3);
        sll.display();

        Node hasilCari;
        hasilCari = sll.search("Vita");
        if (hasilCari == null) {
            System.out.println("Data tidak ditemukan");
        } else {
            System.out.println("Data ditemukan : " + hasilCari.getData());
        }
        System.out.println("data sebelum dihapus");
        sll.display();
        sll.deleteHead();
        System.out.println("data sesudah dihapus");
        sll.display();
    }
}
