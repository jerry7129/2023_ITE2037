package lab02;
import java.util.Scanner;
public class Prac01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] arr = input.split(" ");
		
		int n = arr.length - 1;
		String output = "";
		for(int i=0;i<n;i++) {
			if(i != n-1) {
				output += arr[i].substring(0,1).toUpperCase();
				output += ".";
			}
			else {
				output += arr[i].substring(0,1).toUpperCase();
				output += arr[i].substring(1,arr[i].length()-1);
			}
		}
		output += " submitted ";
		String ref = arr[n].substring(0,1).toUpperCase();
		ref += arr[n].substring(1,arr[n].length());
		ref = ref.replace("pt","df");
		output += ref;
		
		System.out.println("Name Length(Korean) : "+n);
		System.out.println(output);
		
		scan.close();
	}

}
