package EnDecrypt;

import javax.swing.*;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EnDecryptMain {
    JFrame f;
    JPanel p;
    ImageIcon image,icon;
    JButton button;
    JTextField textField;

    EnDecryptMain(){
        f=new JFrame();
        f.setTitle("EnDecrypt");
        f.setSize(500,500);


        p = new JPanel();
        f.setSize(500,500);


        Font font=new Font("Roboto",Font.BOLD,25);
        //creating button
        button=new JButton();
        button.setText("Open Image");
        p.add(button);
        button.setFont(font);

        //creating text field

        textField=new JTextField();
        textField.setBounds(100,200,200,50);
        textField.setFont(font);
        f.add(textField);


        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(null);
        f.add(button);
        f.add(textField);
        f.setVisible(true);

    }

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Encryption Successful");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EnDecryptMain();

    }
}

