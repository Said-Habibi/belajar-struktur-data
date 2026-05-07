# 📚 Struktur Data dengan Java

> Repositori pembelajaran mata kuliah **Struktur Data** menggunakan bahasa pemrograman **Java**

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

---

## 📖 Deskripsi

Repositori ini berisi kumpulan materi, implementasi, dan latihan soal mata kuliah **Struktur Data** yang diajarkan menggunakan bahasa pemrograman Java. Setiap topik dilengkapi dengan penjelasan konsep, implementasi kode, dan contoh penggunaan.

---

## 🗂️ Struktur Direktori

```
Sedang dirapikan 😊
```

---

## 📋 Daftar Materi

| No | Topik | Deskripsi | Status |
|----|-------|-----------|--------|
| 01 | **Array** | Array satu dimensi dan dua dimensi | ✅ Selesai |
| 02 | **Linked List** | Single, Double, dan Circular Linked List | ✅ Selesai |
| 03 | **Stack** | Implementasi stack dengan array dan linked list | ✅ Selesai |
| 04 | **Queue** | Queue, Circular Queue, dan Priority Queue | ✅ Selesai |
| 05 | **Tree** | Binary Tree, BST, dan AVL Tree | ✅ Selesai |
| 06 | **Heap** | Min Heap dan Max Heap | 🔄 Proses |
| 07 | **Graph** | Representasi graf, BFS, dan DFS | 🔄 Proses |
| 08 | **Hash Table** | Hash table dengan berbagai teknik collision handling | 📝 Rencana |
| 09 | **Sorting** | Berbagai algoritma pengurutan | 📝 Rencana |
| 10 | **Searching** | Linear Search dan Binary Search | 📝 Rencana |

**Keterangan:**
- ✅ Selesai
- 🔄 Sedang dikerjakan
- 📝 Direncanakan

---

## ⚙️ Prasyarat

Sebelum menjalankan kode dalam repositori ini, pastikan kamu sudah menginstall:

- **Java Development Kit (JDK)** versi 17 atau lebih baru
- **IDE** yang direkomendasikan:
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
  - [Eclipse](https://www.eclipse.org/)
  - [VS Code](https://code.visualstudio.com/) + Extension Pack for Java

Cek versi Java yang terinstall:
```bash
java -version
javac -version
```

---

## 🚀 Cara Menjalankan

### Clone repositori
```bash
git clone https://github.com/username/struktur-data-java.git
cd struktur-data-java
```

### Kompilasi dan jalankan file Java
```bash
# Kompilasi
javac NamaFile.java

# Jalankan
java NamaFile
```

### Contoh menjalankan materi Stack
```bash
cd 03-Stack
javac StackArray.java
java StackArray
```

---

## 💡 Contoh Kode

### Implementasi Stack dengan Array

```java
public class StackArray {
    private int[] data;
    private int top;
    private int capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack penuh!");
            return;
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println("Top: " + stack.peek()); // 20
    }
}
```

---

## 📊 Kompleksitas Waktu (Big-O)

| Struktur Data | Akses | Pencarian | Penyisipan | Penghapusan |
|---------------|-------|-----------|------------|-------------|
| Array | O(1) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) |
| Stack | O(n) | O(n) | O(1) | O(1) |
| Queue | O(n) | O(n) | O(1) | O(1) |
| Hash Table | O(1) | O(1) | O(1) | O(1) |
| Binary Search Tree | O(log n) | O(log n) | O(log n) | O(log n) |

---

## 🤝 Kontribusi

Kontribusi sangat disambut! Ikuti langkah berikut:

1. **Fork** repositori ini
2. Buat branch baru: `git checkout -b fitur/nama-fitur`
3. Commit perubahan: `git commit -m 'Menambahkan fitur X'`
4. Push ke branch: `git push origin fitur/nama-fitur`
5. Buat **Pull Request**

---

## 📌 Referensi

- 📘 *Introduction to Algorithms* — Cormen, Leiserson, Rivest, Stein (CLRS)
- 📗 *Data Structures and Algorithms in Java* — Robert Lafore
- 📙 *Algoritma dan Struktur Data* — Rinaldi Munir
- 🌐 [GeeksforGeeks - Data Structures](https://www.geeksforgeeks.org/data-structures/)
- 🌐 [Visualgo - Visualisasi Struktur Data](https://visualgo.net/)

---

## 📄 Lisensi

Repositori ini dilisensikan di bawah [MIT License](LICENSE).

---

## 👨‍💻 Tentang

Dibuat untuk keperluan pembelajaran mata kuliah **Struktur Data**.  
Jika ada pertanyaan atau saran, silakan buka [Issue](https://github.com/username/struktur-data-java/issues) atau hubungi melalui email.

---

<div align="center">
  <sub>Dibuat dengan ❤️ untuk mahasiswa yang belajar Struktur Data</sub>
</div>
