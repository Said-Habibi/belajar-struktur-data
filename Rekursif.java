public class Rekursif {
    public int faktorial(int n){
        if (n <= 1){
            return 1;
        }
        return n * faktorial(n - 1);
    }

    // visualisasi memori

    public int Print(int n){
        if (n == 0){
            return 0;
        }
        else {
            System.out.println(n);
            return Print(n - 1);
        }
    }

    // menara hanoi
    public static void hanoi(int n, char sumber, char bantu, char tujuan){
        if (n == 0){
            System.out.println("Pindahkan disk 1 dari "+ sumber+" ke " + tujuan);
        return;
        }
        hanoi(n - 1, sumber, tujuan, bantu);
        System.out.println("Pindahkan disk "+ n + " dari " + sumber + " ke "+ tujuan);
        hanoi(n - 1, sumber, bantu, tujuan);
    }
    static void main(String[] args){
        Rekursif tes = new Rekursif();
        for (int i = 0; i <= 10; i++){
            System.out.printf("%d! = %d\n", i, tes.faktorial(i)); 
        }

        for (int i = 0; i <= 4; i++){
            System.out.printf("Print ke-",i, tes.Print(i));
        }
        tes.Print(4);

        int jumlahDisk = 3;
        hanoi(jumlahDisk, 'A', 'B', 'C');
    }
}
