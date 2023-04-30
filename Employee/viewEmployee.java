package Employee;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class viewEmployee extends JFrame implements ActionListener{

        Choice cemployeeId;
        JTable table;
        JButton search, print, update, back;
        viewEmployee() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel searchlbl = new JLabel("Search by employeeId");
            searchlbl.setBounds(20,20,150,20);
            add(searchlbl);

            cemployeeId = new Choice();
            cemployeeId.setBounds(180,20,150,20);
            add(cemployeeId);

            // Fetch Id's from database
            try {
                Conn c = new Conn();
                Resultset rs = (Resultset) c.s.executeQuery("select * from employee");
                while(((ResultSet) rs).next()) {
                    cemployeeId.add(((ResultSet) rs).getString("empId"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // View the table
            table = new JTable();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from employee");
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0, 100, 900, 600);
            add(jsp);

            // Buttons
            search = new JButton("Search");
            search.setBounds(20, 70, 80, 20);
            search.addActionListener(this);
            add(search);
            
            print = new JButton("Print");
            print.setBounds(120, 70, 80, 20);
            print.addActionListener(this);
            add(print);
            
            update = new JButton("Update");
            update.setBounds(220, 70, 80, 20);
            update.addActionListener(this);
            add(update);
            
            back = new JButton("Back");
            back.setBounds(320, 70, 80, 20);
            back.addActionListener(this);
            add(back);
        

            setLocation(300, 100);
            setSize(900, 700);
            setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == search) {
                String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ae.getSource() == print) {
                try {
                    table.print();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ae.getSource() == update) {
                setVisible(false);
                new updateEmployee(cemployeeId.getSelectedItem());
            } else {
                setVisible(false);
                new Home();
            }
        }
    public static void main(String[] args) {
        new viewEmployee();
    }

   
}
