# Penjelasan Kode & Cara Kerja: Implementasi Tree Pencarian Buku

Dokumen ini menjelaskan struktur data Binary Search Tree (BST) yang diimplementasikan dalam program pencarian buku perpustakaan, beserta penjelasan alur kerja setiap kelas dan metodenya tanpa mengulang penulisan seluruh kode sumber.

---

## 🏗️ Struktur Kelas dan Tanggung Jawab

Sistem ini terbagi menjadi empat kelas utama yang saling berinteraksi:

### 1. Kelas `Buku`
Kelas ini merupakan representasi entitas data buku di perpustakaan. Tanggung jawab utamanya adalah menyimpan informasi masing-masing buku.
* **`isbn`** (String): Kode identifikasi unik buku.
* **`judul`** (String): Kunci utama (key) yang digunakan oleh pohon biner untuk menentukan posisi penempatan data dan melakukan pencarian.
* **`penulis`** (String): Nama penulis buku.
* **`tahunTerbit`** (int): Tahun publikasi buku.
* **`toString()`**: Mengembalikan format string yang rapi untuk mencetak detail buku ke konsol.

### 2. Kelas `SimpulBuku`
Merupakan elemen pembentuk dasar (node) dari pohon biner. Kelas ini bertanggung jawab atas struktur struktural pohon biner:
* **`buku`** (Buku): Menyimpan data objek buku sesungguhnya pada simpul tersebut.
* **`kiri`** (SimpulBuku): Referensi ke simpul anak kiri, yang menyimpan buku-buku dengan judul secara alfabetis lebih kecil dibanding simpul ini.
* **`kanan`** (SimpulBuku): Referensi ke simpul anak kanan, yang menyimpan buku-buku dengan judul secara alfabetis lebih besar atau sama dibanding simpul ini.

### 3. Kelas `PohonPencarianBuku`
Merupakan kelas yang mengimplementasikan seluruh operasi dari struktur data **Binary Search Tree (BST)** secara rekursif:
* **`tambahBuku(Buku)`**: Memasukkan buku ke dalam pohon. Metode pembantu rekursif membandingkan judul buku baru dengan judul buku pada simpul saat ini secara *case-insensitive* menggunakan fungsi `compareToIgnoreCase`. Buku baru diarahkan ke cabang kiri jika judulnya lebih kecil secara alfabetis, dan ke cabang kanan jika lebih besar atau sama.
* **`cariBuku(String)`**: Mencari buku berdasarkan kata kunci judul buku secara persis (*exact match*). Logikanya membandingkan judul pencarian dengan judul simpul saat ini; jika tidak cocok, ia memutuskan untuk mencari ke sub-pohon kiri atau kanan secara rekursif berdasarkan urutan alfabetis.
* **`tampilkanSemuaBuku()`**: Melakukan penelusuran **In-Order Traversal** (Sub-pohon Kiri -> Simpul Saat ini -> Sub-pohon Kanan). Karena sifat BST, metode ini secara otomatis mencetak semua buku di perpustakaan berurutan dari A sampai Z secara alfabetis.
* **`hitungTotalBuku()`**: Menghitung jumlah seluruh buku dalam pohon secara rekursif. Rumusnya adalah `1` (untuk simpul saat ini) ditambah hasil perhitungan rekursif di sub-pohon `kiri` ditambah hasil perhitungan di sub-pohon `kanan`.
* **`apakahKosong()`**: Mengembalikan nilai boolean apakah pohon tersebut kosong (`akar == null`).

### 4. Kelas `AplikasiPerpustakaan`
Kelas ini menyediakan antarmuka pengguna berbasis teks (CLI) interaktif untuk mempermudah eksekusi program.
* Berisi fungsi `main` yang membuat instance `PohonPencarianBuku` dan mengisinya dengan 5 buku default sebagai sampel awal.
* Menampilkan menu dengan 5 opsi: Tambah Buku, Cari Buku, Tampilkan Semua Buku (Urutan A-Z), Tampilkan Jumlah Buku, dan Keluar.
* Mengukur performa pencarian dalam satuan milidetik menggunakan `System.nanoTime()` untuk memperlihatkan kecepatan efisiensi pencarian pada struktur data Tree.

---

## 🔄 Cara Kerja Algoritma Pencarian & Penambahan

Struktur data BST bekerja dengan prinsip membagi ruang pencarian menjadi dua pada setiap simpul:

1. **Operasi Penambahan (Insertion)**:
   * Dimulai dari `akar` pohon. Jika pohon kosong, buku baru langsung menjadi `akar`.
   * Jika tidak kosong, judul buku dibandingkan. Jika judul buku baru secara alfabetis lebih kecil dari judul di simpul saat ini, ia ditambahkan ke sub-pohon kiri secara rekursif. Jika lebih besar atau sama, ia ditambahkan ke sub-pohon kanan.
   * Proses ini berulang hingga menemukan ruang kosong (`null`) untuk membuat simpul baru.

2. **Operasi Pencarian (Search)**:
   * Dimulai dari `akar`.
   * Jika judul yang dicari cocok dengan judul di simpul saat ini, data buku langsung dikembalikan.
   * Jika tidak cocok dan judul yang dicari secara alfabetis lebih kecil, pencarian bergerak ke cabang kiri. Jika lebih besar, pencarian bergerak ke cabang kanan.
   * Setiap langkah pencarian memotong separuh dari kemungkinan jalur pencarian yang tersisa ($O(\log n)$), membuat operasi pencarian berjalan sangat cepat bahkan dengan jumlah buku yang sangat banyak.
