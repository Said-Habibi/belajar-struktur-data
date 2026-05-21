package Search;
import Search.Squent.Squential;
import Search.Binary.BinarySearch;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    Squential s = new Squential();
    BinarySearch b = new BinarySearch();    
    Scanner input = new Scanner(System.in);
    int data[] = {2,5,8,12,16,23,38,45,56,72};
    System.out.println("Data : ");
    for (int i = 0; i < data.length; i++) {
        System.out.print(data[i] + " ");
    }
    System.out.print("\n\nMasukan data yang dicari : ");
    int cari = input.nextInt();
    s.sequentialSearch(data, cari);
    b.binarySearch(data, cari);
    input.close();
    }
}