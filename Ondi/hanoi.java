package Ondi;

public class hanoi {
    public static void hanoi(int n, char sumber, char bantu, char tujuan){
        if (n == 0){
            System.out.println("Pindahkan disk 1 dari "+ sumber+" ke " + tujuan);
        return;
        }
        hanoi(n - 1, sumber, tujuan, bantu);
        System.out.println("Pindahkan disk "+ n + " dari " + sumber + " ke "+ tujuan);
        hanoi(n - 1, sumber, bantu, tujuan);
    }
    public static void main(String[] args) {
        int jumlahDisk = 3;
        hanoi(jumlahDisk, 'A', 'B', 'C');
    }
}
