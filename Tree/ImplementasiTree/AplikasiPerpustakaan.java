package Tree.ImplementasiTree;

import java.util.Scanner;

public class AplikasiPerpustakaan {
    public static void main(String[] args) {
        PohonPencarianBuku perpustakaan = new PohonPencarianBuku();
        Scanner pemindai = new Scanner(System.in);

        perpustakaan.tambahBuku(new Buku("978-602-03-3160-7", "Laskar Pelangi", "Andrea Hirata", 2005));
        perpustakaan.tambahBuku(new Buku("978-979-1227-02-5", "Bumi Manusia", "Pramoedya Ananta Toer", 1980));
        perpustakaan.tambahBuku(new Buku("978-602-291-663-5", "Pulang", "Tere Liye", 2015));
        perpustakaan.tambahBuku(new Buku("978-979-22-3860-0", "Ronggeng Dukuh Paruk", "Ahmad Tohari", 1982));
        perpustakaan.tambahBuku(new Buku("978-602-0822-34-1", "Supernova", "Dee Lestari", 2001));

        boolean berjalan = true;

        System.out.println("=================================================");
        System.out.println("   Selamat Datang di Aplikasi Perpustakaan BST   ");
        System.out.println("=================================================");
        System.out.println("Sistem pencarian buku menggunakan Binary Search Tree (BST).");
        System.out.println("Semua data terurut secara otomatis berdasarkan judul.");
        System.out.println();

        while (berjalan) {
            System.out.println("-------------------------------------------------");
            System.out.println("MENU UTAMA:");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Cari Buku (Berdasarkan Judul)");
            System.out.println("3. Tampilkan Semua Buku (Urut Alfabetis)");
            System.out.println("4. Tampilkan Jumlah Total Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            String pilihan = pemindai.nextLine().trim();

            switch (pilihan) {
                case "1":
                    System.out.println("\n--- Tambah Buku Baru ---");
                    System.out.print("Masukkan ISBN         : ");
                    String isbn = pemindai.nextLine().trim();
                    System.out.print("Masukkan Judul Buku   : ");
                    String judul = pemindai.nextLine().trim();
                    System.out.print("Masukkan Penulis      : ");
                    String penulis = pemindai.nextLine().trim();
                    
                    int tahun = 0;
                    boolean tahunValid = false;
                    while (!tahunValid) {
                        System.out.print("Masukkan Tahun Terbit : ");
                        try {
                            tahun = Integer.parseInt(pemindai.nextLine().trim());
                            tahunValid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("[PERINGATAN] Tahun harus berupa angka! Silakan coba lagi.");
                        }
                    }

                    if (judul.isEmpty()) {
                        System.out.println("[GAGAL] Judul buku tidak boleh kosong! Batal menambahkan.");
                    } else {
                        Buku bukuBaru = new Buku(isbn, judul, penulis, tahun);
                        perpustakaan.tambahBuku(bukuBaru);
                        System.out.println("[SUKSES] Buku \"" + judul + "\" berhasil dimasukkan ke dalam BST!");
                    }
                    break;

                case "2":
                    System.out.println("\n--- Cari Buku ---");
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String kataKunci = pemindai.nextLine().trim();
                    
                    if (kataKunci.isEmpty()) {
                        System.out.println("[PERINGATAN] Kata kunci pencarian tidak boleh kosong!");
                        break;
                    }

                    System.out.println("Mencari di dalam Binary Search Tree...");
                    long waktuMulai = System.nanoTime();
                    Buku hasilCari = perpustakaan.cariBuku(kataKunci);
                    long waktuSelesai = System.nanoTime();

                    if (hasilCari != null) {
                        System.out.println("\n[BUKU DITEMUKAN!]");
                        System.out.println("ISBN         : " + hasilCari.getIsbn());
                        System.out.println("Judul        : " + hasilCari.getJudul());
                        System.out.println("Penulis      : " + hasilCari.getPenulis());
                        System.out.println("Tahun Terbit : " + hasilCari.getTahunTerbit());
                        System.out.printf("Kecepatan Cari: %.3f milidetik\n", (waktuSelesai - waktuMulai) / 1_000_000.0);
                    } else {
                        System.out.println("\n[BUKU TIDAK DITEMUKAN]");
                        System.out.println("Buku dengan judul \"" + kataKunci + "\" tidak terdaftar di perpustakaan.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Daftar Buku di Perpustakaan (Urut A-Z) ---");
                    perpustakaan.tampilkanSemuaBuku();
                    break;

                case "4":
                    System.out.println("\n--- Jumlah Total Buku ---");
                    System.out.println("Saat ini terdapat " + perpustakaan.hitungTotalBuku() + " buku di dalam perpustakaan.");
                    break;

                case "5":
                    System.out.println("\nTerima kasih telah menggunakan Aplikasi Perpustakaan BST!");
                    berjalan = false;
                    break;

                default:
                    System.out.println("\nPilihan tidak valid! Silakan masukkan angka dari 1 sampai 5.");
                    break;
            }
            System.out.println();
        }

        pemindai.close();
    }
}
