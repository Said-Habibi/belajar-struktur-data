# Penjelasan Kode: Sistem Antrian Pelanggan (Queue)

Dokumentasi ini menjelaskan implementasi struktur data antrian (Queue) untuk simulasi loket pelayanan pelanggan yang terdapat pada package `Proyek`.

---

## 🏗️ Struktur Proyek

Terdapat tiga file utama dalam proyek ini:
1. `Pelanggan.java` – Representasi data pelanggan (Node).
2. `Queque.java` – Struktur data antrian kustom menggunakan Linked List.
3. `Main.java` – Kelas pengendali program (Driver) dengan menu interaktif CLI.

---

## 1. Pelanggan.java (Node Antrian)

Kelas `Pelanggan` digunakan sebagai objek data sekaligus sebagai **Node** di dalam antrian. Dalam konsep Linked List, sebuah Node harus menyimpan data miliknya sendiri serta pointer/referensi ke Node berikutnya.

### Struktur Atribut:
- `nomorAntrean` (`String`): Nomor tiket unik pelanggan (contoh: `CS-001` atau `TL-002`).
- `nama` (`String`): Nama lengkap pelanggan.
- `jenisLayanan` (`String`): Jenis pelayanan yang dipilih (Customer Service atau Teller).
- `waktuMasuk` (`String`): Waktu saat pelanggan mengambil antrian.
- `next` (`Pelanggan`): Referensi ke objek `Pelanggan` berikutnya di belakangnya. Ini adalah kunci dari linked list.

---

## 2. Queque.java (Struktur Data Antrian)

Kelas ini mengimplementasikan struktur data **Queue** menggunakan prinsip **FIFO (First In, First Out)**: elemen yang pertama kali dimasukkan adalah yang pertama kali dilayani/dikeluarkan.

### Pointer Utama:
- `front`: Menunjuk ke pelanggan paling depan (yang akan dilayani berikutnya).
- `rear`: Menunjuk ke pelanggan paling belakang (tempat pelanggan baru masuk).
- `size`: Menyimpan jumlah antrian yang sedang menunggu saat ini.

### Penjelasan Metode (Method):

#### a. `enqueue(Pelanggan pelanggan)` (Menambah Antrian)
Metode ini menambahkan pelanggan baru ke bagian belakang (`rear`) antrian. Kompleksitas waktunya adalah **$O(1)$** karena kita memegang pointer `rear` secara langsung.
* **Logika**: 
  1. Jika antrian kosong (`front == null`), maka pelanggan baru akan menjadi `front` sekaligus `rear`.
  2. Jika sudah ada antrian, maka pointer `next` milik `rear` saat ini diarahkan ke pelanggan baru (`rear.next = pelanggan`). Setelah itu, `rear` digeser ke pelanggan yang baru masuk tersebut (`rear = pelanggan`).
  3. Nilai `size` ditambah 1.

#### b. `dequeue()` (Mengambil/Melayani Antrian)
Metode ini mengambil dan menghapus pelanggan di antrian terdepan (`front`) untuk dilayani. Kompleksitas waktunya adalah **$O(1)$**.
* **Logika**:
  1. Jika antrian kosong, mengembalikan `null`.
  2. Menyimpan referensi `front` saat ini sebagai `removed`.
  3. Menggeser `front` ke node berikutnya (`front = front.next`).
  4. Jika setelah digeser `front` menjadi `null`, berarti antrian sekarang kosong, maka `rear` juga disetel menjadi `null`.
  5. Nilai `size` dikurangi 1.
  6. Memutus pointer `next` dari node yang dihapus (`removed.next = null`) demi keamanan memori (*Garbage Collection*).

#### c. `peek()` (Melihat Antrian Terdepan)
Mengembalikan data `front` tanpa menghapusnya dari antrian. Berguna untuk mengetahui siapa giliran berikutnya.

#### d. `isEmpty()` & `size()`
- `isEmpty()`: Mengembalikan `true` jika `front == null`.
- `size()`: Mengembalikan jumlah antrian saat ini.

---

## 3. Main.java (Alur Program CLI)

Kelas ini bertugas sebagai penghubung antara pengguna dengan struktur data antrian. Di dalamnya terdapat loop interaktif `while(true)` dan pemindai input `Scanner`.

### Fitur Interaktif Menu:
1. **Tambah Pelanggan (Enqueue)**: 
   Menerima nama dan pilihan layanan dari pengguna. Nomor antrian digenerate berdasarkan jenis layanan:
   - `CS-xxx` untuk Customer Service.
   - `TL-xxx` untuk Teller.
2. **Layani Pelanggan (Dequeue)**: 
   Memanggil pelanggan terdepan untuk diproses, menambah counter total yang telah dilayani hari ini, dan menampilkan pesan panggilan.
3. **Tampilkan Antrean**: 
   Melakukan penelusuran (*traversal*) dari `front` hingga `rear` dengan perulangan `while(temp != null)` untuk menampilkan semua pelanggan yang sedang menunggu.
4. **Lihat Pelanggan Terdepan (Peek)**: 
   Menampilkan info pelanggan yang berada di urutan pertama antrian tanpa memprosesnya.
5. **Statistik Antrean**: 
   Menampilkan ringkasan hari ini seperti jumlah antrian tersisa, total pelanggan terlayani, dan status panggilan aktif.
6. **Reset Antrean**: 
   Mengosongkan semua antrian (`clear()`) dan menyetel kembali nomor antrian ke nol.
