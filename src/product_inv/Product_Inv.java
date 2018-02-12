
package product_inv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Product_Inv {

    public static void main(String[] args) {
        
       Scanner myscan = new Scanner(System.in);
   System.out.println("Enter ID of Product ");
  String pid =myscan.next();
  System.out.println("Enter Name of Product ");

  String pname = myscan.next();
  
  System.out.println("Enter Brand of Product ");
  String pbrand = myscan.next();
  System.out.println("Enter Price of Product ");
  int pprice = myscan.nextInt();
  
  System.out.println("Enter Quantity of Product ");
 int qty = myscan.nextInt();
 
   try {
   Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/Product_Inventory",
"root", "root");

   PreparedStatement ps =con.prepareStatement("insert into"
+ " Product values(?,?,?,?,?)");
 
  ps.setString(1, pid);
    ps.setString(2, pname);
     ps.setString(3, pbrand);
      ps.setInt(4, pprice);
       ps.setInt(5, qty);

 int count = ps.executeUpdate();

  if(count > 0)
 
   System.out.println("Record Inserted"); 
   else
    System.out.println("Record Not Inserted"); 
   con.close();
   } 
catch (Exception e) 
{
   e.printStackTrace();
  
        }
    }
    
}
