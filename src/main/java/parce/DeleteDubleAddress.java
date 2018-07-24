package parce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;

public class DeleteDubleAddress {

	
	public void deleteDubleAddress() {
		ArrayList<String> address = LoadAddress.getaddress();
		for(int i = address.size()-1; i>=0;i--) {
			for(int j = i-1; j>=0;j--) {
				if(address.get(i).equals(address.get(j)))
					address.remove(j);
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("address")));
			
			for (String string : address) {
				bw.write(string);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
