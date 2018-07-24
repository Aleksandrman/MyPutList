package parce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadAddress {
	private static ArrayList<String> address = new ArrayList<String>();
	private static 	LoadAddress la = new LoadAddress();
	private LoadAddress() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("address")));
			while(bf.ready()) {
			address.add(bf.readLine());
					}
			bf.close();
		} catch (IOException e) {
			
		}
	}
	public static ArrayList<String> getaddress() {
		return address;
	}
}
