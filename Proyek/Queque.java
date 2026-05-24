package Proyek;

public class Queque {
    private Pelanggan front;
    private Pelanggan rear;
    private int size;

    public Queque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add a customer to the rear of the queue
    public void enqueue(Pelanggan pelanggan) {
        if (pelanggan == null) {
            return;
        }
        
        if (isEmpty()) {
            front = pelanggan;
            rear = pelanggan;
        } else {
            rear.next = pelanggan;
            rear = pelanggan;
        }
        size++;
    }

    // Remove and return the front customer
    public Pelanggan dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        Pelanggan removed = front;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        removed.next = null; // 
        return removed;
    }

    // fungsi untuk mengecek pelanggan tanpa menghapusnya dari antrian
    public Pelanggan peek() {
        return front;
    }

    // ngecek apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }

    // mengambil jumlah pelanggan dalam antrian
    public int size() {
        return size;
    }

    // mengambil pelanggan paling depan tanpa menghapusnya dari antrian
    public Pelanggan getFront() {
        return front;
    }

    // menghapus semua pelanggan dari antrian
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
