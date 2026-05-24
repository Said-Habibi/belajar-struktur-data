import datetime as date
class Pelanggan:
    def __init__(self,nomor_antrean: str, nama: str, jenis_layanan: str, waktu_masuk: str):
        self._nomor_antrean = nomor_antrean
        self._nama = nama
        self._jenis_layanan = jenis_layanan
        self._waktu_masuk = waktu_masuk
        self.next = None
    def get_nomor_antrean(self) -> str:
        return self._nomor_antrean
    def get_nama(self) -> str:
        return self._nama
    def get_jenis_layanan(self) -> str:
        return self._jenis_layanan
    def get_waktu_masuk(self) -> str:
        return self._waktu_masuk
    def __str__(self) -> str:
        return f"[{self._nomor_antrean}] {self._nama} - {self._jenis_layanan} (Masuk: {self._waktu_masuk})"
class Queque:
    def __init__(self):
        self._front = None
        self._rear = None
        self._size = 0

    # Menambahkan pelanggan ke bagian belakang (rear) antrean
    def enqueue(self, pelanggan: 'Pelanggan') -> None:
        if pelanggan is None:
            return
        
        if self.is_empty():
            self._front = pelanggan
            self._rear = pelanggan
        else:
            self._rear.next = pelanggan
            self._rear = pelanggan
            
        self._size += 1

    # Menghapus dan mengembalikan pelanggan di posisi depan (front)
    def dequeue(self) -> 'Pelanggan':
        if self.is_empty():
            return None
        
        removed = self._front
        self._front = self._front.next
        
        # Jika antrean menjadi kosong setelah dihapus
        if self._front is None:
            self._rear = None
            
        self._size -= 1
        removed.next = None  # Melepas referensi next dari node yang dihapus
        return removed

    # Fungsi untuk mengecek pelanggan di depan tanpa menghapusnya dari antrean
    def peek(self) -> 'Pelanggan':
        return self._front

    # Mengecek apakah antrean kosong
    def is_empty(self) -> bool:
        return self._front is None

    # Mengambil jumlah pelanggan dalam antrean
    def size(self) -> int:
        return self._size

    # Mengambil pelanggan paling depan tanpa menghapusnya dari antrean
    # (Sama fungsionalitasnya dengan peek())
    def get_front(self) -> 'Pelanggan':
        return self._front

    # Menghapus semua pelanggan dari antrean
    def clear(self) -> None:
        self._front = None
        self._rear = None
        self._size = 0

antrean = Queque()
totalServed: int = 0
csCounter: int = 0
tellerCounter: int = 0
sedangDilayani: Pelanggan = None


while True:
    print("\n=== Sistem Antrean Pelanggan ===")
    print("1. Tambah Pelanggan")
    print("2. Panggil Pelanggan")
    print("3. tampilkan antrean")
    print("4. Cek Pelanggan Terdepan")
    print("5. Tampilkan Statistik Antrean")
    print("6. Reset Antrean")
    print("0. Keluar")

    pilihan = input("Pilih menu (1-6): ")
    if pilihan == '0':
        print("\nTerima kasih telah menggunakan sistem antrean. Sampai jumpa!")
        break

    match pilihan:
        case '1':
            nama: str = input("\nMasukan Nama Pelanggan: ").strip()
            if nama == None or nama == "":
                print("nama tidak boleh kosong")
                break
            
            print("Pilih jenis layanan")
            print("1. Custumer Service")
            print("2. Teller")
            inputOpt: str = input("pilihan 1/2: ").strip()
            
            if inputOpt != '1' and inputOpt != '2':
                print("pilihan tidak valid")
                break
            
            jenis_layanan: str = "Custumer Service"
            prefix: str = "CS"
            count: int = 0
            if inputOpt == '2':
                jenis_layanan = "Teller"
                prefix = "TL"
                tellerCounter += 1
                count = tellerCounter
            else:
                csCounter += 1
                count = csCounter
            
            ticketNo: str = f"{prefix},{count}"
            waktu_masuk: str = date.datetime.now().strftime("%H:%M:%S")
            pelanggan = Pelanggan(ticketNo, nama, jenis_layanan, waktu_masuk)
            antrean.enqueue(pelanggan)
            
            print(f"Pelanggan {nama} dengan nomor antrean {ticketNo} telah ditambahkan ke dalam antrean.")
            
        case '2':
            if antrean.is_empty():
                print("\nTidak ada pelanggan dalam antrean")
            else:
                sedangDilayani = antrean.dequeue()
                totalServed += 1
                print(f"\nPelanggan {sedangDilayani.get_nama()} dengan nomor antrean {sedangDilayani.get_nomor_antrean()} sedang dilayani.")
        
        case '3':
            if antrean.is_empty():
                print("\nAntrean kosong")
            else:
                print("\ndaftar antrian tunggu")
                temp: Pelanggan = antrean.get_front()
                while temp is not None:
                    print(temp)
                    temp = temp.next
                print(f"\ntotal menunggu {antrean.size()} orang")
        
        case '4':
            depan: Pelanggan = antrean.peek()
            if depan is None:
                print("\nantrean kosong")
            else:
                print("\nPelanggan terdepan dalam antrean: ")
                print(depan)
        
        case '5':
            print("\nstatistik antrian hari ini")
            print(f"total pelanggan yang dilayani: {totalServed}")
            print(f"total pelanggan custumer service: {csCounter}")
            print(f"total pelanggan teller: {tellerCounter}")
            print(f"pelanggan yang sedang dilayani: {sedangDilayani.get_nama() if sedangDilayani is not None else 'Tidak ada pelanggan yang sedang dilayani'}")
            
        case '6':
            confirm: str = input("\napakah anda yakin untuk menyetel ulang semua antrean? (y/n)").strip().lower()
            if confirm == 'y':
                antrean.clear()
                totalServed = 0
                csCounter = 0
                tellerCounter = 0
                sedangDilayani = None
                print("\nantrean telah disetel ulang")
            else:
                print("\nreset antrean dibatalkan")
        case _:
            print("\npilihan tidak valid, silakan pilih menu yang tersedia")
        