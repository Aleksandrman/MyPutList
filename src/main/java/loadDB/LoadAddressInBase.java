package loadDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import parce.*;

public class LoadAddressInBase {
	 private static final String url="jdbc:mysql://localhost:3306/shopvideo_pt?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC	";
	 private static final String username="root";
	 private static final String password="root";
	
	 
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 ArrayList<String> address = parce.LoadAddress.getaddress(); 
		 
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection(url,username,password);
		  Statement st = con.createStatement();
		 for (String string : address) {
			 try {
				 st.execute("Insert into addresses(address, id_client) values('"+string+"',0);");
			} catch (Exception e) {
			e.getMessage(); 
			System.out.println("незагрузился");
			}
			
		}
		 st.close();
		  
	}
}
