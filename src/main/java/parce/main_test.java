package parce;

import java.io.IOException;
import java.util.ArrayList;

import org.getDistance.GetDistAndTime;
import org.json.JSONException;

public class main_test {
public static void main(String[] args) throws IOException, InterruptedException {
	Thread th = new Thread(new Parce());
	th.start();
//	Parce p = new Parce();
//	p.parce();
	
//	
//	GenerateRoutes gr = new GenerateRoutes();
//	gr.getAddress();
}
}
