package EnDecrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EnDecryptMain implements ActionListener {
    JFrame f;
    JPanel p;
    ImageIcon image, icon;
    JButton button;
    JTextField textField;
    Font font;

    EnDecryptMain() {
        font = new Font("Roboto", Font.BOLD, 25);
        icon = new ImageIcon("resource/");

        //JFrame
        f = new JFrame();
        f.setTitle("EnDecrypt");


        //JPanel
        p = new JPanel();


        //creating button
        button = new JButton();
        button.setText("Select Image");
        button.setBounds(150, 200, 200, 50);
        button.setFont(font);
        button.setBackground(Color.pink);
        p.add(button);

        //creating text field
        textField = new JTextField();
        textField.setBounds(150, 100, 200, 30);
        textField.setFont(font);
        p.add(textField);


        //JPanel Properties
        p.setBounds(0, 0, 500, 500);
        p.setLayout(null);
        p.setVisible(true);
        f.add(p);


        //JFrame Properties
        f.setBounds(0, 0, 500, 500);
        f.setIconImage(icon.getImage());
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        //file FileInputStream
        try {

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Encryption Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        if (e.getSource() == button) {
            System.out.println("button clicked");
            int temp = Integer.parseInt(text);
            operate(temp);
        }

    }

    public static void main(String[] args) {
        new EnDecryptMain();
    }
}

