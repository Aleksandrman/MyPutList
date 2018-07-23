package parce;

import java.io.IOException;
import java.util.ArrayList;

import org.getDistance.GetDistAndTime;
import org.json.JSONException;

public class Parce extends Thread{
	private GetDistAndTime dist = new GetDistAndTime();
	private ArrayList<PairAddress> routeArr = new ArrayList<PairAddress>();
	private GenerateRoutes gr = new GenerateRoutes();

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			
			parce();
		} catch (IOException e) {
			System.out.println("RUN");
		}
	}

	public void parce() throws IOException {
routeArr = gr.getAddress();


for (PairAddress pair : routeArr) {
	System.out.println(pair.getA()+ " "+ pair.getB());
}




	for (PairAddress pair : routeArr) {
		String a = pair.getA();
		String b = pair.getB();
//		System.out.println(a + b);
		try {
			String route = dist.get_address(a, b);
		} catch (JSONException e) {
			System.err.println("ОПС!!!");
			
		}
		System.out.println(dist.getDist() + " " +dist.getTime()+ " " +a+" "	+b);
	
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	}
}
