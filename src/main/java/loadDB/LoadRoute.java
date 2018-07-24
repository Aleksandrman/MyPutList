package loadDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import parce.*;

public class LoadRoute {
	 private static final String url="jdbc:mysql://localhost:3306/shopvideo_pt?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC	";
	 private static final String username="root";
	 private static final String password="root";
	
	
	ArrayList<Rout> rout = new ArrayList();
	
	
	public void loadRout(ArrayList<Rout> arr) {
		
		rout = arr;
		 try {
			 ChekAddress ca = new ChekAddress();
			 String a= null;
			 String b = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection(url,username,password);
			  Statement st = con.createStatement();
			  
			  for (Rout rout2 : rout) {
				a = ca.getaddressid(rout2.getA());
				b = ca.getaddressid(rout2.getB());
				int dist = Integer.parseInt(rout2.getDist());
				int time = Integer.parseInt(rout2.getTime());
				st.execute("Insert into routes(id_address_a, id_address_b, dist, time) values('"+a+"','"+b+"','"+dist+"','"+time+"');");
				
			}
			  
			  con.close(); 
			  st.close();
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}
