package wallets;
import java.io.IOException;

public class NegativeException extends Exception {
	public NegativeException(){
		super("price must be positive");
	}
}
