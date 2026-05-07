package Praktikum10;

public class Node {
    private String data;
    private Node nextReference;

    // constructor
    public Node(String data) {
        this.data = data;
        this.nextReference = null;
    }

    // getter untuk mengambil nilai data
    public String getData() {
        return data;
    }

    // setter untuk mengubah nilai data
    public void setData(String data) {
        this.data = data;
    }

    // getter untuk mengambil nilai nextReference
    public Node getNextReference() {
        return nextReference;
    }

    // setter untuk mengubah nilai nextReference
    public void setNextReference(Node nextReference) {
        this.nextReference = nextReference;
    }
}