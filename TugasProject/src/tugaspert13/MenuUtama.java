package tugaspert13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import tugaspert12.GUIMainClass12;   // <-- Import dari package lain

public class MenuUtama extends JFrame {

    public MenuUtama() {
        setTitle("Menu Utama");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Selamat datang di Menu Utama!", SwingConstants.CENTER);
        JButton btnOpenGUI12 = new JButton("Buka GUIMainClass12");

        // Aksi tombol untuk membuka GUI dari package tugaspert12
        btnOpenGUI12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIMainClass12 gui12 = new GUIMainClass12();
                gui12.setVisible(true);
            }
        });

        add(label);
        add(btnOpenGUI12);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuUtama().setVisible(true);
        });
    }
}
