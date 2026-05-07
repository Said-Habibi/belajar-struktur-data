public class Main {
    public static void main(String[] args) {
        Queue2 q = new Queue2(3);

        q.enQueue(5);
        q.enQueue(10);
        q.enQueue(15);

        q.display();
        System.out.println("Data yang keluar " + q.deQueue());

        q.display();
        // methode peek belum ada
        q.peek();
    }
}
