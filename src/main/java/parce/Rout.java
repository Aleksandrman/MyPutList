package parce;

public class Rout {
private String a;
private String b;
private String dist;
private String time;

Rout(String a, String b, String dist, String time) {
	this.a = a;
	this.b = b;
	this.dist = dist;
	this.time = time;
}

/**
 * @return the a
 */
public String getA() {
	return a;
}

/**
 * @return the b
 */
public String getB() {
	return b;
}

/**
 * @return the dist
 */
public String getDist() {
	return dist;
}

/**
 * @return the time
 */
public String getTime() {
	return time;
}
}
