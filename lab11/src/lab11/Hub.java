package lab11;

public class Hub {
	private int number;
	private String description;
	private String area;
	private double price_per_box;
	
	public Hub(int number, String description, String area, double price_per_box) {
		this.number = number;
		this.description = description;
		this.area = area;
		this.price_per_box = price_per_box;
	}
	public int getNumber() {
		return number;
	}
	public String getDescription() {
		return description;
	}
	public String getArea() {
		return area;
	}
	public double getPrice_per_box() {
		return price_per_box;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setDescription(String discription) {
		this.description = discription;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setPrice_per_box(double price) {
		this.price_per_box = price;
	}
	public String toString() {
		String str = "";
		str += "Box Number : ";
		str += number;
		str += "\nDescription : ";
		str += description;
		str += "\nArea : ";
		str += area;
		str += "\nPrice per box : ";
		str += price_per_box;
		return str;
	}
}
