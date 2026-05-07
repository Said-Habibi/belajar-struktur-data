package Tugas10;

public class AStack {
    private static final int MAX_SIZE = 100;
    private int size;
    private String[] elements;

    public AStack(){
        size = -1;
        elements = new String[MAX_SIZE];
    }

    public void push(String element){
        if (size < MAX_SIZE - 1){
            size++;
            elements[size] = element;
        } else {
            System.out.println("Stack overflow!");
        }
        
    }

    public String pop(){
        if (isEmpty()){
            System.out.println("Stack underflow tidak ada data yang dapat diambil");
            return null;
        }
        return elements[size--];
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        return elements[size];
    }

    public boolean isEmpty(){
        return size == -1;
    }
}
