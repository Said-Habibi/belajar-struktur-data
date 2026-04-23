package Praktikum9;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null) && (this.tail == null);
    }

    public int getSize() {
        return size;
    }

    public void addFirst(Node node) {
        if (!isEmpty()) {
            node.setNextReference(head);
            head = node;
        } else {
            node.setNextReference(null);
            tail = node;
            head = node;
        }
        ++this.size;
    }

    public void addLast(Node node) {
        if (!isEmpty()) {
            node.setNextReference(null);
            this.tail.setNextReference(node);
            tail = node;
        } else {
            node.setNextReference(null);
            tail = node;
            head = node;
        }
        ++this.size;
    }

    public void display() {
        Node pointer;
        pointer = head;
        System.out.println("Size : " + this.size);
        while (pointer != null) {
            System.out.println(pointer.getData());
            pointer = pointer.getNextReference();
        }
    }

    public Node search(String data) {
        Node pointer;
        if (isEmpty()) {
            return null;
        }
        pointer = head;
        while (pointer != null) {
            if (pointer.getData().contentEquals(data)) {
                return pointer;
            }
            pointer = pointer.getNextReference();
        }
        return null;
    }

    public void deleteHead() {
        if (!isEmpty()) {
            Node pointer;
            pointer = head;
            head = pointer.getNextReference();
            pointer = null;
            // Jika setelah dihapus list jadi kosong, tail juga harus null
            if (head == null) {
                tail = null;
            }
            --this.size;
        }
    }
}
