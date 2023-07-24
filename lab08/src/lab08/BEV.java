package lab08;

import java.time.LocalDate;

public class BEV extends Car{
	private static int carNum = 0;
	private static int CO2emission = 0;
	private int GHGPERCAR = 25;
	
	public BEV() {
		
	}
	public BEV(String name, LocalDate date, int carNum) {
		super(name, date);
		this.carNum += carNum;
		this.CO2emission += carNum * GHGPERCAR;
	}
	public boolean equals(BEV a) {
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
		System.out.println("BEV emit CO2 most when generating eletric energy");
		return CO2emission;
	}
}
