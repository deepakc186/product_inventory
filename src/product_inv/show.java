
package product_inv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class show {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Product_Inventory","root","root");
            Statement st = con.createStatement();
            System.out.println("enter name");
            String pname=scan.next();
            System.out.println("enter brand");
            String pbrand=scan.next();
            System.out.println("enter product id");
            int pid=scan.nextInt();
            PreparedStatement ps =con.prepareStatement(
"update Product set Product_Name = ?,Product_Brand=? where Product_ID = ?");
            ps.setString(1, pname);
            ps.setString(2,pbrand);
            ps.setInt(3, pid);
   
            int count = ps.executeUpdate();
   if(count > 0)
    System.out.println("Record Updated"); 
   else
    System.out.println("Record Not Updated");

            ps.setString(1, pname);
            ps.setInt(2, pid);
            ResultSet rs = st.executeQuery("select * from Product");
                    if(rs.isBeforeFirst())
	    			{
					while(rs.next())
					{
		
			System.out.println(" ID : "+rs.getString("Product_ID")
	
				+" Name : "+rs.getString("Product_Name")

					+" Brand : "+rs.getString("Product_Brand")
	
				+" Price : "+ rs.getInt("Product_Price")
	
				+" Qty : "+ rs.getInt("Product_Qty"));
					}
				}	
				else
			System.out.println(" No records Found ");
      con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
