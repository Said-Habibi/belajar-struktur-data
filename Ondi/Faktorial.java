package Ondi;

public class Faktorial {
    public int faktorial(int n){
        if (n <= 1){
            return 1;
        }
        return n * faktorial(n - 1);
    }

    public static void main(String[] args) {
        Faktorial tes = new Faktorial();
        for (int i = 0; i <= 10; i++){
            System.out.printf("%d! = %d\n", i, tes.faktorial(i)); 
        }
    }
}
