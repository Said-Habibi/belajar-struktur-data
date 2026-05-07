package Praktikum11.Tugas.QueueLinkedList;

public class QueueLL {
    private Node front;
    private Node rear;
    private int size;
    public QueueLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public void enQueue(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Dimasukan: " + data);
    }

    public int deQueue() {
        if(isEmpty()){
            System.out.println("Underflow! Antrean kosong");
            return -1;
        }
        int removed = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        return removed;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Antrean kosong");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Antrean kosong");
            return;
        }
        System.out.print("isi antrean (front -> rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}
