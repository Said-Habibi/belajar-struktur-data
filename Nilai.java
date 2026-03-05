import java.util.Scanner;
public class Nilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan nilai: ");
        double nilai = input.nextDouble();

        if (nilai < 30){
            System.out.println("nilai E");
        }
        else if (nilai >= 30 && nilai <50){
            System.out.println("nilai D");
        }
        else if (nilai >= 50 && nilai <70){
            System.out.println("nilai C");
        }
        else if (nilai >= 70 && nilai <80){
            System.out.println("nilai B");
        }
        else if (nilai >= 80){
            System.out.println("nilai A");
        }
        input.close();
    }
}
