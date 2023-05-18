import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface BangunRuang {
    int getVolume();
}

public class Bangun implements ActionListener,BangunRuang  {
    private JFrame frame;
    private JPanel panel;
    private JLabel label1, label2, label3;
    private JComboBox<String> comboBox;
    private JTextField input1, input2, input3;
    private JButton button;

    public Bangun() {
        frame = new JFrame("Program Menghitung Volume Bangun Ruang");
        panel = new JPanel();

        label1 = new JLabel("Pilih Bangun Ruang:");
        label2 = new JLabel("Masukkan Panjang:");
        label3 = new JLabel("Masukkan Tinggi:");

        String[] bangunRuang = {"Balok", "Limas Segi Empat", "Prisma Segitiga", "Tabung"};
        comboBox = new JComboBox<>(bangunRuang);

        input1 = new JTextField(10);
        input2 = new JTextField(10);
        input3 = new JTextField(10);

        button = new JButton("Hitung");
        button.addActionListener(this);

        panel.add(label1);
        panel.add(comboBox);
        panel.add(label2);
        panel.add(input1);
        panel.add(label3);
        panel.add(input2);
        panel.add(input3);
        panel.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(panel);
        frame.setVisible(true);

    }
    public int getVolume() {
        String bangun = (String)comboBox.getSelectedItem();
        double p = Double.parseDouble(input1.getText());
        double t = Double.parseDouble(input2.getText());
        double r = Double.parseDouble(input3.getText());
        double volume = 0;
        if (bangun.equals("Balok")) {
            volume = p * t * r;
        } else if (bangun.equals("Limas Segi Empat")) {
            volume = (1.0/3.0) * p * t * r;
        } else if (bangun.equals("Prisma Segitiga")) {
            volume = (1.0/2.0) * p * t * r;
        } else if (bangun.equals("Tabung")) {
            volume = Math.PI * Math.pow(r, 2) * t;
        }
        return (int) Math.round(volume);
    }
    public void actionPerformed(ActionEvent e) {
        String bangun = (String)comboBox.getSelectedItem();

        JOptionPane.showMessageDialog(frame, "Volume " + bangun + " adalah " + getVolume());
    }

    public static void main(String[] args) {
        Bangun gui = new Bangun();
    }
}