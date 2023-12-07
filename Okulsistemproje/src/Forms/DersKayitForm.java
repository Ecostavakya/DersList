package Forms;

import Models.Ders;
import Services.FileService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DersKayitForm extends JFrame {

    private JTextField tfDersKodu;
    private JButton btnOk;
    private JTextField tfDersIsmi;
    private JPanel DersKayitForm;
    private JButton btnClear;

    Ders ders = new Ders();

    String dersKodu = ders.DersKodu;
    String dersIsmi = ders.DersIsmi;

    public DersKayitForm() {

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dersKodu = tfDersKodu.getText();
                dersIsmi = tfDersIsmi.getText();
                System.out.println(dersKodu);
                FileService fileService = new FileService();

                fileService.writeToFile("src/Data", "Ders.txt", dersKodu, dersIsmi);


            }
        });

        setContentPane(DersKayitForm);
        setTitle("Ders Kayıt Form");
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfDersKodu.setText("");
                tfDersIsmi.setText("");
            }
        });
    }

    public static void main(String[] args) {
        DersKayitForm dersKayitForm = new DersKayitForm();

    }
}