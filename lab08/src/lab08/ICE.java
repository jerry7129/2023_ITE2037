package lab08;
import java.time.*;

public class ICE extends Car{
	private static int carNum = 0;
	private static int CO2emission = 0;
	private int GHGPERCAR = 35;
	
	public ICE() {
		
	}
	public ICE(String name, LocalDate date, int carNum) {
		super(name, date);
		this.carNum += carNum;
		this.CO2emission += carNum * GHGPERCAR;
	}
	public boolean equals(ICE a) {
		if(a.date.equals(date) && a.name.equals(name))return true;
		return false;
	}
	public String toString() {
		String str = "";
		str += "Name: ";
		str += name;
		str += ", date: ";
		str += date;
		str += ", carNum: ";
		str += carNum;
		return str;
	}
	public int totalCO2() {
		System.out.println("ICE emit CO2 most when driving");
		return CO2emission;
	}
}
