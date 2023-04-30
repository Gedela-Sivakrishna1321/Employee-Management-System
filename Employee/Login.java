package Employee;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

public class Login extends JFrame implements ActionListener{

    JTextField tfusername,tfpassword;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setLocation(350, 200);
        setSize(600, 300);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon("Icons\\icons\\second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
     


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            String username = tfusername.getText();
            String password = tfpassword.getText();

            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password ='"+password+"'";

            Resultset rs = (Resultset) c.s.executeQuery(query);
            if(((ResultSet) rs).next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }

        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
   
}
