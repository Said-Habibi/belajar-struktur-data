package Praktikum11.Tugas.QueueLinkedList;

public class Main {
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.display();
        System.out.println("Peek: " + q.peek());
        System.out.println("deQueue: " + q.deQueue());
        System.out.println("deQueue: " + q.deQueue());
        
        q.display();
        System.out.println("ukuran: " + q.size());
    }
}
