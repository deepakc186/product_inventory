
package product_inv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class delete {
    public static void main(String[] args) {
        try{
                 Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/Product_Inventory",
"root", "root");

                Statement stmt=con.createStatement();
                
                    int result=stmt.executeUpdate("insert into product values(3,'Printer','Hewlett-Packard',4356,10)");
                    System.out.println(result+" records affected");  
con.close();  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
