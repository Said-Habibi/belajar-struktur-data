package Praktikum11.Program2;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enQueue(int data) {
        if (isFull()){
            System.out.println("Overflow! Antrean");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        count++;
        System.out.println("Dimasukan: " + data);
    }

    public int deQueue(){
        if (isEmpty()){
            System.out.println("Underflow! antrean kosong");
            return -1;
        }
        int x = arr[front];
        front = (front + 1) % capacity;
        count--;
        return x;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];    
    }

    public int getRear () {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return (count == 0);
    }

    public boolean isFull(){
        return (count == capacity);
    }
}
