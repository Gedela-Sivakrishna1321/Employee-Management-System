package Employee;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove;

    Home() {
        setLayout(null);
        // Background Image
        ImageIcon i1 = new ImageIcon("Icons//icons//home.jpg");
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,1120,630);
        add(Image);
        
        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620,20 , 400, 40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        Image.add(heading);

        // View, add, update, remove Buttons
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        Image.add(add);


        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        Image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        Image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        Image.add(remove);

        setSize(1120,630);
        setLocation(100, 100);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add) {
            setVisible(false);
            new addEmployee();
        } else if (e.getSource() == update) {
            setVisible(false);
             new viewEmployee();
        } else if (e.getSource() == view) {
            setVisible(false);
            new viewEmployee();
        } else {
            setVisible(false);
            new removeEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
    
}
