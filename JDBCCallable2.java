package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCallable2
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/callable";
    static final String USER = "root";
    static final String PASS = "surya@9489";

    public static void main(String[] args)
    {
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            CallableStatement cs = conn.prepareCall("{call addStudent(?,?,?)}");

            cs.setInt(1, 101);
            cs.setString(2, "Surya");
            cs.setInt(3, 95);

            cs.execute();

            System.out.println("Student record inserted successfully");

            cs.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
