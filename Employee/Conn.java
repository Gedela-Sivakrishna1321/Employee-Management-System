package Employee;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeManagement", "root", "sivakrishna@1321");
            s = c.createStatement();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

}
