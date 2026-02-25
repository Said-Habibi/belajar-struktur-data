# ERD - Tugas Pertemuan 4 (Simple)

Diagram relasi data berdasarkan [TugasPertemuan4Simple.java](file:///home/said/Documents/GitHub/belajar-struktur-data/TugasPertemuan4Simple.java)

## Entity Relationship Diagram

```mermaid
erDiagram
    PRODI {
        string nama_prodi PK
    }

    MAHASISWA {
        int nim PK
        string nama
        string prodi FK
    }

    KTM {
        string no_ktm PK
        int nim FK
    }

    MATA_KULIAH {
        string kode_mk PK
        string nama_matkul
    }

    NILAI {
        int nim FK
        string kode_mk FK
        int nilai_angka
        string nilai_huruf
    }

    PRODI ||--o{ MAHASISWA : "One-to-Many"
    MAHASISWA ||--|| KTM : "One-to-One"
    MAHASISWA ||--o{ NILAI : "mengambil"
    MATA_KULIAH ||--o{ NILAI : "diambil"
```

> **NILAI** adalah tabel penghubung (associative table) yang membentuk relasi **Many-to-Many** antara MAHASISWA dan MATA_KULIAH.

## Diagram Relasi

```mermaid
graph LR
    subgraph "One-to-One"
        M1["Mahasiswa"] --- K1["KTM"]
    end

    subgraph "One-to-Many"
        P1["1 Prodi"] --> MA1["Mahasiswa 1"]
        P1 --> MA2["Mahasiswa 2"]
        P1 --> MA3["Mahasiswa N..."]
    end

    subgraph "Many-to-Many"
        MH1["Mahasiswa 1"] --> N1["Nilai"]
        MH2["Mahasiswa 2"] --> N1
        N1 --> MK1["Mata Kuliah 1"]
        N1 --> MK2["Mata Kuliah 2"]
    end
```

## Alur Logika Rekursif

```mermaid
flowchart TD
    A["tampilMahasiswaRekursif(index)"] --> B{"index >= ukuran list?"}
    B -- Ya --> C["BERHENTI (Base Case)"]
    B -- Tidak --> D["Cetak data mahasiswa ke-index"]
    D --> E["Panggil diri sendiri: tampilMahasiswaRekursif(index + 1)"]
    E --> A
```
