#!/usr/bin/env python

class Buku:
    def __init__(self, isbn, judul, penulis, tahunTerbit):
        self.isbn = isbn
        self.judul = judul
        self.penulis = penulis
        self.tahunTerbit = tahunTerbit
    
    def getIsbn(self):
        return self.isbn
    
    def setIsbn(self, isbn):
        self.isbn = isbn
    
    def getJudul(self):
        return self.judul
    
    def setJudul(self, judul):
        self.judul = judul
    
    def getPenulis(self):
        return self.penulis
    
    def setPenulis(self, penulis):
        self.penulis = penulis
    
    def getTahunTerbit(self):
        return self.tahunTerbit
    
    def setTahunTerbit(self, tahunTerbit):
        self.tahunTerbit = tahunTerbit
    
    def __str__(self):
        return f"Buku [ISBN: {self.isbn} | Judul: \"{self.judul}\" | Penulis: {self.penulis} | Tahun: {self.tahunTerbit}]"
    
class PohonPencarianBuku:
    def __init__(self):
        self.akar = None
    
    def tambahBuku(self, bukuBaru):
        self.akar = self.tambahRekursif(self.akar, bukuBaru)
    
    def tambahRekursif(self, simpulSekarang, bukuBaru):
        if simpulSekarang == None:
            return SimpulBuku(bukuBaru)
        
        perbandingan = bukuBaru.getJudul().lower().compareToIgnoreCase(simpulSekarang.buku.getJudul().lower())
        if perbandingan < 0:
            simpulSekarang.kiri = self.tambahRekursif(simpulSekarang.kiri, bukuBaru)
        else:
            simpulSekarang.kanan = self.tambahRekursif(simpulSekarang.kanan, bukuBaru)
        
        return simpulSekarang
    
    def cariBuku(self, judul):
        hasil = self.cariRekursif(self.akar, judul)
        if hasil != None:
            return hasil.buku
        else:
            return None
    
    def cariRekursif(self, simpulSekarang, judul):
        if simpulSekarang == None or simpulSekarang.buku.getJudul().lower() == judul:
            return simpulSekarang
        
        perbandingan = judul.lower().compareToIgnoreCase(simpulSekarang.buku.getJudul().lower())
        if perbandingan < 0:
            hasil = self.cariRekursif(simpulSekarang.kiri, judul)
        else:
            hasil = self.cariRekursif(simpulSekarang.kanan, judul)
        
        return hasil
    
    def apakahKosong(self):
        return self.akar == None
    
    def tampilkanSemuaBuku(self):
        if self.apakahKosong():
            print("Perpustakaan masih kosong. Belum ada buku yang terdaftar.")
            return
        
        self.tampilkanInOrder(self.akar)
    
    def tampilkanInOrder(self, simpulSekarang):
        if simpulSekarang != None:
            self.tampilkanInOrder(simpulSekarang.kiri)
            print("  " + str(simpulSekarang.buku))
            self.tampilkanInOrder(simpulSekarang.kanan)
    
    def hitungTotalBuku(self):
        return self.hitungTotalRekursif(self.akar)
    
    def hitungTotalRekursif(self, simpulSekarang):
        if simpulSekarang == None:
            return 0
        
        return 1 + self.hitungTotalRekursif(simpulSekarang.kiri) + self.hitungTotalRekursif(simpulSekarang.kanan)