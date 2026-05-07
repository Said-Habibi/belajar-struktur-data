import javax.swing.JOptionPane;

public class DoWhileLoop {
    public static void main(String[] args) {
        String aa = JOptionPane.showInputDialog("Masukan nilah");
        int a = Integer.parseInt(aa);

        do{
            System.out.println(a+" saya akan rajin berdoa dan belajaar");
            a++;
        }
        while(a<=5);
    }
}
