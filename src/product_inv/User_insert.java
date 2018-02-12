
package product_inv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class User_insert {
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_inventory","root","root");
        
            PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
            
            Scanner scan=new Scanner(System.in);
            
            do{
            int pid;
                System.out.println("enter id of product");
                pid=scan.nextInt();
                
            String pname;
                System.out.println("enter product name");
                pname=scan.next();
                
             String pbrand;
                System.out.println("enter product brand");
                pbrand=scan.next();
                
             int pprice;
                System.out.println("enter product price");
                pprice=scan.nextInt();
             
             int qty;
                System.out.println("enter product quantity");
                qty=scan.nextInt();
                
                ps.setInt(1,pid);  
                ps.setString(2,pname);  
                ps.setString(3,pbrand);  
                ps.setInt(4,pprice);  
                ps.setInt(5,qty);  
                
                int i=ps.executeUpdate();
                System.out.println(i+"records affected");
                
                System.out.println("do you want to continue:y/n");
                
                String s=scan.next();
                
                if(s.startsWith("n"))
                {
                break;
                }
            }
            while(true);
                    
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
