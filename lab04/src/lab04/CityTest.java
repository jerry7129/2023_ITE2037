package lab04;

public class CityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City Seoul = new City("Seoul",23,45);
		City Paris = new City("Paris",123,41);
		City Racoon_City = new City("Racoon City");
		City Mega_City = new City("Mega City");
		
		System.out.println(Seoul);
		System.out.println(Paris);
		System.out.println(Racoon_City);
		System.out.println(Mega_City);
		
		System.out.print("Seoul-Paris : ");
		System.out.println(City.distance(Seoul, Paris));
		System.out.print("Seoul-Racoon City : ");
		System.out.println(City.distance(Seoul, Racoon_City));
		System.out.print("Paris-Mega City : ");
		System.out.println(City.distance(Paris, Mega_City));
	}

}
