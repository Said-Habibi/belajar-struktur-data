package Tugas10;
import Tugas10.*;
public class LStack {
    private static final int MAX_SIZE = 100;
    private int size;
    private SingleLinkedList elements;

    public LStack(){
        size = -1;
        elements = new SingleLinkedList();
    }

    public boolean isEmpty(){
        return size == -1;
    }

    public void push(String element){
        if (size < MAX_SIZE - 1){
            Node e = new Node(element);
            elements.addFirst(e);
            size++;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
            String s = peek();
            elements.deleteHead();
            size--;
            return s;
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("Stack overflow");
           return null;
        }
        Node e = elements.getNode(0);
        return (e != null) ? e.getData() : null;
    }
    // boolean isEmpty = new SingleLinkedList().isEmpty();
    // public boolean isEmpty() {
        // return (this.head == null) && (this.tail == null);
    // }

    
}
