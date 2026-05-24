package Proyek;

/*
Contributor:
1. Nasyifa 
2. Zara
3. Dila
4. Naiya
5. Said
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Queque antrian = new Queque();
    private static int totalServed = 0;
    private static int csCounter = 0;
    private static int tellerCounter = 0;
    private static Pelanggan sedangDilayani = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("  SISTEM ANTRIAN PELANGGAN LOKET         ");
        System.out.println("=========================================");

        while (true) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Pelanggan ke Antrean (Enqueue)");
            System.out.println("2. Layani Pelanggan Berikutnya (Dequeue)");
            System.out.println("3. Tampilkan Seluruh Antrean");
            System.out.println("4. Lihat Pelanggan Terdepan (Peek)");
            System.out.println("5. Tampilkan Statistik Antrean");
            System.out.println("6. Reset Seluruh Antrean");
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih opsi menu (0-6): ");

            String inputOpt = sc.nextLine().trim();
            if (inputOpt.equals("0")) {
                System.out.println("\nKeluar dari program. Terima kasih!");
                break;
            }

            switch (inputOpt) {
                case "1":
                    System.out.print("\nMasukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    if (nama.isEmpty()) {
                        System.out.println("[Error] Nama tidak boleh kosong.");
                        break;
                    }
                    
                    System.out.println("Pilih Layanan:");
                    System.out.println("1. Customer Service (CS)");
                    System.out.println("2. Teller (TL)");
                    System.out.print("Pilihan (1/2): ");
                    String optLay = sc.nextLine().trim();

                    if (!optLay.equals("1") && !optLay.equals("2")) {
                        System.out.println("[Error] Pilihan layanan tidak valid.");
                        break;
                    }
                    String layanan = "Customer Service";
                    String prefix = "CS";
                    int count = 0;
                    
                    if (optLay.equals("2")) {
                        layanan = "Teller";
                        prefix = "TL";
                        tellerCounter++;
                        count = tellerCounter;
                    } else {
                        csCounter++;
                        count = csCounter;
                    }
                    
                    String ticketNo = String.format("%s-%03d", prefix, count);
                    String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    
                    Pelanggan baru = new Pelanggan(ticketNo, nama, layanan, time);
                    antrian.enqueue(baru);
                    
                    System.out.println("\n-----------------------------------------");
                    System.out.println("        STRUK ANTRIAN DICETAK");
                    System.out.println("-----------------------------------------");
                    System.out.println("   No. Antrean : " + ticketNo);
                    System.out.println("   Nama        : " + nama);
                    System.out.println("   Layanan     : " + layanan);
                    System.out.println("   Jam Masuk   : " + time);
                    System.out.println("-----------------------------------------");
                    break;

                case "2":
                    if (antrian.isEmpty()) {
                        System.out.println("\n[Info] Antrean kosong. Tidak ada pelanggan untuk dilayani.");
                    } else {
                        sedangDilayani = antrian.dequeue();
                        totalServed++;
                        System.out.println("\n=========================================");
                        System.out.println("   >>> PANGGILAN ANTREAN: " + sedangDilayani.getNomorAntrean() + " <<<");
                        System.out.println("=========================================");
                        System.out.println("  Pelanggan: " + sedangDilayani.getNama());
                        System.out.println("  Silakan menuju loket: " + sedangDilayani.getJenisLayanan());
                        System.out.println("=========================================");
                    }
                    break;

                case "3":
                    if (antrian.isEmpty()) {
                        System.out.println("\n[Info] Antrean kosong.");
                    } else {
                        System.out.println("\n--- DAFTAR ANTRIAN TUNGGU ---");
                        Pelanggan temp = antrian.getFront();
                        int idx = 1;
                        while (temp != null) {
                            System.out.println(idx + ". " + temp);
                            temp = temp.next;
                            idx++;
                        }
                        System.out.println("Total menunggu: " + antrian.size() + " orang");
                    }
                    break;

                case "4":
                    Pelanggan depan = antrian.peek();
                    if (depan == null) {
                        System.out.println("\n[Info] Antrean kosong.");
                    } else {
                        System.out.println("\nPelanggan terdepan dalam antrean:");
                        System.out.println(depan);
                    }
                    break;

                case "5":
                    System.out.println("\n--- STATISTIK ANTRIAN HARI INI ---");
                    System.out.println("Jumlah Menunggu  : " + antrian.size() + " orang");
                    System.out.println("Total Dilayani   : " + totalServed + " orang");
                    System.out.println("Sedang Dilayani  : " + (sedangDilayani != null ? sedangDilayani : "-"));
                    break;

                case "6":
                    System.out.print("\nApakah Anda yakin ingin menyetel ulang semua antrean? (y/N): ");
                    String confirm = sc.nextLine().trim();
                    if (confirm.equalsIgnoreCase("y")) {
                        antrian.clear();
                        csCounter = 0;
                        tellerCounter = 0;
                        totalServed = 0;
                        sedangDilayani = null;
                        System.out.println("[Info] Seluruh antrean berhasil disetel ulang.");
                    }
                    break;

                default:
                    System.out.println("\n[Error] Pilihan menu tidak valid.");
            }
        }
        sc.close();
    }
}
