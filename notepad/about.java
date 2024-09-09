package notepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class about extends JFrame implements ActionListener{
    JButton button1;
    about() {
        this.setTitle("About");
        this.setLayout(null);
        this.setBounds(400, 100, 600, 500);

        ImageIcon i1 = new ImageIcon(getClass().getResource("windowsicon.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // changing the image i2 (of image class ) to imageicon class
        JLabel headericon = new JLabel(i3);
        headericon.setBounds(70, 40, 400, 80);

        ImageIcon i4 = new ImageIcon(getClass().getResource("wish-list.png"));
        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5); // changing the image i2 (of image class ) to imageicon class
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(50, 180, 70, 70);

        JLabel text1 = new JLabel("<html>Microsoft Windows <br> Version 22H2 (OS Build: 19045.2386) <br> © Microsoft Corporation, All rights reserved. <br> <br> The Windows 10 Hom Single Language opeating system and its user<br>  interface are protected by trademarks and other pending or existing <br> intellectual property rights in the United States and other <br> countries/ Regions <br><br><br><br> This Product is liscensed under the Microsoft Software Liscence Terms to: <br>      Windows User  </html>");
        text1.setBounds(150, 100, 500, 300);
        text1.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        
        button1 = new JButton("OK");
        button1.setBounds(150,400,120,25);
        button1.setFocusPainted(false);
        button1.addActionListener(this);
        

        this.add(button1);
        this.add(icon1);
        this.add(text1);
        this.add(headericon);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new about();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            System.exit(0);
        }
    }
}
