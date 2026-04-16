import javax.swing.JOptionPane;

public class SimpleOOP {
    public static void main(String[] args) {
        System.out.println("Hello World");
        JOptionPane.showMessageDialog(null, "Hello World");
        String nama = JOptionPane.showInputDialog("Masukkan nama Anda");
        JOptionPane.showMessageDialog(null, "Halo " + nama);
    }
}