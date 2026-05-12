package Tugas.QueueGenshinImpactCloud;

public class MainApp {
    public static void main(String[] args) {
        
        GenshinCloudQueue cloudQueue = new GenshinCloudQueue(10);

        System.out.println("========================================");
        System.out.println("   SIMULASI ANTREAN GENSHIN CLOUD       ");
        System.out.println("========================================");

        
        System.out.println("\n--- Menambahkan Pemain ke Antrean ---");
        cloudQueue.enqueue("Traveler_Lumine");
        cloudQueue.enqueue("Diluc_Master");
        cloudQueue.enqueue("Paimon_EmergencyFood");
        cloudQueue.enqueue("Zhongli_GeoDaddy");
        cloudQueue.enqueue("Raiden_Ei");

        
        cloudQueue.displayQueue();

        System.out.println("\n--- Memproses Antrean (Mulai Bermain) ---");
        cloudQueue.dequeue(); 
        cloudQueue.dequeue(); 

        System.out.println("\nPemain berikutnya yang akan main: " + cloudQueue.peekNext());
        System.out.println("Total pemain yang masih menunggu: " + cloudQueue.getQueueCount());

        cloudQueue.displayQueue();

        System.out.println("\nSimulasi selesai. Traveler lainnya tetap mengantre...");
    }
}
