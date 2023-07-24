package wallets;

public class TooMuchExpenseException extends Exception {
	private int inputNum;
	public TooMuchExpenseException() {
		super("Not enough balance.");
	}
	public TooMuchExpenseException(int expense) {
		super("Over the limit!");
		inputNum = expense;
	}
	public int getInputNum() {
		return inputNum;
	}
}
