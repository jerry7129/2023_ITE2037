package lab04;

public class City {

	private String name;
	private int locationX, locationY;
	
	public City(String name, int locationX, int locationY) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	public City(String name) {
		this.name = name;
		this.locationX = (int)(Math.random()*360);
		this.locationY = (int)(Math.random()*360);
	}
	public String getter_name() {
		return this.name;
	}
	public int getter_locationX() {
		return this.locationX;
	}
	public int getter_locationY() {
		return this.locationY;
	}
	public boolean equals(City c) {
		if(c.name == name && 
			c.locationX == locationX && 
			c.locationY == locationY) {
			return true;
		}
		return false;
	}
	public String toString() {
		String str ="";
		str += name;
		str += ", ";
		str += locationX;
		str += ", ";
		str += locationY;
		return str;
	}
	public static double distance(City a, City b) {
		double x1 = a.locationX, y1 = a.locationY;
		double x2 = b.locationX, y2 = b.locationY;
		double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return distance;
	}
}
