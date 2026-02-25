import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing {
    public static void main(String[] args) {
        // Menggunakan SwingUtilities untuk memastikan thread safety [2]
        SwingUtilities.invokeLater(() -> {
            // 1. Membuat JFrame (Jendela Utama)
            JFrame frame = new JFrame("Contoh Aplikasi");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);


            // 2. Membuat JPanel (Wadah Komponen)
            JPanel panel = new JPanel();
            // Panel menggunakan layout manager (default: FlowLayout) [6]
            panel.setLayout(new GridBagLayout()); // Mengatur posisi ke tengah [2]

            // 3. Membuat JButton (Tombol)
            JButton tombol = new JButton("Klik Saya");
            tombol.setBounds(810,1070,800,600);
            
            // Menambahkan aksi pada tombol
            tombol.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Tombol telah diklik!");
                }
            });

            // 4. Menambahkan komponen
            panel.add(tombol); // Tambah tombol ke panel
            frame.add(panel); // Tambah panel ke frame [1]

            // 5. Menampilkan Frame
            frame.setLocationRelativeTo(null); // Tengah layar
            frame.setVisible(true);
        });
    }
}
