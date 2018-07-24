package parce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateRoutes {
	private ArrayList<String> address = new ArrayList<String>();
	private static ArrayList<PairAddress> route = new ArrayList<PairAddress>();
public ArrayList getAddress(){
	address = parce.LoadAddress.getaddress();
	for(int i = 0; i<address.size();i++) {
		for(int j = i+1; j <address.size(); j++) {
			String a = address.get(i).substring(0, 6);
			String b = address.get(j).substring(0, 6);
			
			if(!(a.equals(b)))			
		route.add(new PairAddress(address.get(i), address.get(j)));
		}
	}
	for (PairAddress pair : route) {
		System.out.println(pair.getA()+ " "+ pair.getB());
	}
	return route;
}
}
