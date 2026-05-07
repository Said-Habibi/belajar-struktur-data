public class RekursifAlokasiMemori {
    public int Print(int n) {
        if (n == 0) {
            return 0;
        } else {
            System.out.println(n);
            return Print(n - 1);
        }
    }

    public static void main(String[] args) {
        RekursifAlokasiMemori tes = new RekursifAlokasiMemori();
        tes.Print(4);
    }
}
