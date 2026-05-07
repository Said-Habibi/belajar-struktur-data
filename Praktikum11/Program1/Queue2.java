public class Queue2{
    private int[] arr;
    private int rear;
    private int capacity;

    public Queue2(int size) {
        capacity = size;
        arr = new int[capacity];
        rear = -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void enQueue (int data) {
        if (isFull()) {
            System.out.println("Antrean penuh");
        } else {
            arr[++rear] = data;
            System.out.println(data + "masuk antrean");
        }
    }

    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Antrean kosong");
            return -1;
        }
        int frontElement = arr[0];
        for (int i = 0; i < rear; i++){
            arr[i] = arr[i + 1];
        }
        rear--;
        return frontElement;
    }

    public int size(){
        return rear + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrean kosong");
            return;
        }
        System.out.println("isi antrean: ");
        for (int i = 0; i <= rear; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    // menambahkan methode peek untuk melihat barisan paling depan
    public void peek(){
        if (isEmpty()){
            System.out.println("Antrean kosong");
        }
        System.out.println("Elemen depan: "+arr[0]);
    }

}