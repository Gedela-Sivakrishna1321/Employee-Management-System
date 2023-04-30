package Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstPage extends JFrame implements ActionListener{

    FirstPage() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setLocation(100, 50);
        setSize(1170, 650);
       
       
        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(120,20 ,1200 ,70 );
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

        // Displaying the Image
        ImageIcon i1 = new ImageIcon("Icons\\icons\\front.jpg");
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);


        // Click here button
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLUE);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);



        setVisible(true);
       
    }

    public static void main(String[] args) {
        new FirstPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
