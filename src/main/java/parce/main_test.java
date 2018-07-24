package parce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import org.getDistance.GetDistAndTime;
import org.json.JSONException;

import loadDB.ChekAddress;

public class main_test {
public static void main(String[] args) throws IOException, InterruptedException {
	Parce p = new Parce();
	Thread th = new Thread(p);
	th.start();
	 
	
	
//	DeleteDubleAddress da =new DeleteDubleAddress();
//	da.deleteDubleAddress();
	
	try {
		ChekAddress ca = new ChekAddress();
		System.out.println(ca.getaddressid("664009 Иркутск Омулевского 33а"));
	} catch (SQLException e) {
		System.out.println("ошибка");
		e.printStackTrace();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
//	GenerateRoutes gr = new GenerateRoutes();
//	gr.getAddress();
}
}
