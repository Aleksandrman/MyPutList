package loadDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChekAddress {
	 String url="jdbc:mysql://localhost:3306/shopvideo_pt?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC	";
	    String username="root";
	    String password="root";
	    Connection con;
	  
	    
	  public  ChekAddress() throws ClassNotFoundException, SQLException{
			
			
			
	    }
	public String getaddressid(String addr) throws SQLException, ClassNotFoundException {
		String res = "";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			
			 ResultSet resultSet = st.executeQuery("Select * from addresses where address = '"+addr+"';");
			 
			 
			
			 while (resultSet.next()){
 	        	
				 res  = resultSet.getString(1);
 	           
 	        }
			 st.close();
			 con.close();
			 return res;
			 
			
			
			
		
		
		
	}
}
