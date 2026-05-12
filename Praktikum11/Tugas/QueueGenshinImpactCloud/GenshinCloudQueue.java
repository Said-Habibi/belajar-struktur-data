package Tugas.QueueGenshinImpactCloud;

public class GenshinCloudQueue {
    private String[] queue;
    private int rear;
    private int capacity;

    public GenshinCloudQueue(int size) {
        this.capacity = size;
        this.queue = new String[capacity];
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void enqueue(String playerName) {
        if (isFull()) {
            System.out.println("\n[!] Antrean Penuh! Server sedang sibuk, silakan coba lagi nanti.");
        } else {
            queue[++rear] = playerName;
            System.out.println("\n[+] " + playerName + " telah masuk ke dalam antrean.");
            System.out.println("Posisi saat ini: " + (rear + 1));
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("\n[!] Antrean Kosong. Tidak ada pemain yang menunggu.");
            return null;
        }
        
        String playingPlayer = queue[0];
        
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        
        rear--;
        System.out.println("\n[>>] " + playingPlayer + " sekarang bisa mulai bermain!");
        return playingPlayer;
    }
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("\n[i] Antrean saat ini kosong.");
            return;
        }
        
        System.out.println("\n--- DAFTAR ANTREAN GENSHIN CLOUD ---");
        for (int i = 0; i <= rear; i++) {
            System.out.println((i + 1) + ". " + queue[i]);
        }
        System.out.println("------------------------------------");
    }

    public int getQueueCount() {
        return rear + 1;
    }

    public String peekNext() {
        if (isEmpty()) return "Kosong";
        return queue[0];
    }
}
