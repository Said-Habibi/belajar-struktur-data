package Ondi;

public class Print {
     public int Print(int n){
        if (n == 0){
            return 0;
        }
        else {
            System.out.println(n);
            return Print(n - 1);
        }
    }
    public static void main(String[] args) {
        Print tes = new Print(); 
        for (int i = 0; i <= 4; i++){
            System.out.printf("" + tes.Print(i));
        }
        tes.Print(4);
    }
}
