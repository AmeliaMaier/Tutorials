/*http://www.homeandlearn.co.uk/java/connect_to_a_database_using_java_code.html
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lia
 */
public class DBConnect
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            // TODO code application logic here
            String host = "jdbc:derby://localhost:1527/Employees";
            String userName = "testing";
            String password = "testing";
            Connection con = DriverManager.getConnection(host, userName, password);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Workers";
            ResultSet rs = stmt.executeQuery(SQL);
            while ( rs.next( ) ) {
            int id_col = rs.getInt("ID");
            String first_name = rs.getString("First_Name");
            String last_name = rs.getString("Last_Name");
            String job = rs.getString("Job_Title");
            System.out.println( id_col + " " + first_name + " " + last_name + " " + job );
            }
            
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }

    }

}
