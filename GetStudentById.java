package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetStudentById 
{

    static final String DB_URL = "jdbc:mysql://localhost:3306/callable";
    static final String USER = "root";
    static final String PASS = "surya@9489";

    public static void main(String[] args) 
    {

        int studentId = 101; 

        String sql = "{call getStudentById(?)}";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             CallableStatement cs = conn.prepareCall(sql)) 
        {

            cs.setInt(1, studentId);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) 
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println("Student Details:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Marks: " + marks);
            } 
            else 
            {
                System.out.println("No student found with ID " + studentId);
            }

            rs.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}

