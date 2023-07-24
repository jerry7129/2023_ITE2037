package wallets;

public class Wallet {
	private String name;
	private int balance;
	private int txIndex;
	
	public Wallet(String name) {
		this.name = name;
		balance = 100;
		txIndex = 0;
	}
	public int getBalance() {
		return balance;
	}
	public void increaseIndex() {
		++txIndex;
	}
	public void decreaseBalance(int expence) {
		balance -= expence;
	}
	public String toString() {
		String str = "";
		str += "name: ";
		str += this.name;
		str += ", #";
		str += this.txIndex;
		str += ", balance: ";
		str += this.balance;
		return str;
	}
	public void empty() throws Exception{
		if(balance <= 0) {
			throw new Exception("Go Home");
		}
	}
}
