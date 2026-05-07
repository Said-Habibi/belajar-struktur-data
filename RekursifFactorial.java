public class RekursifFactorial {
    public int faktorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }

    public static void main(String[] args) {
        RekursifFactorial tes = new RekursifFactorial();
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d! = %d\n", i, tes.faktorial(i));
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + tes.faktorial(i));
        }
    }
}
