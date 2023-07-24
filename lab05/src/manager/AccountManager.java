package manager;

import java.time.LocalDate;
import account.Account;

public class AccountManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate created = LocalDate.of(2021, 12, 1);
		Account account = new Account("Kim",5,created);
		int year = created.getYear(), month = created.getMonthValue(), cnt = 0;
		boolean check = true;
		while(account.getBalance()<10000) {
			account.receiveIncome(100);
			account.receiveInterest();
			month++;
			if(month > 12) {
				year++;
				month = 1;
				cnt++;
			}
			if(cnt >= 1 && month == 1) {
				int a = (int)(Math.random()*10);
				if(a==7) {
					System.out.println("이벤트 당첨!");
					account.receiveIncome(100);
				}
			}
			if(cnt == 3 && check) {
				account.increaseYearlyInterest(2);
				System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");
				check = false;
			}
		}
		
		System.out.print(account);
		System.out.println(", 1억 모으기 끝!: "+year+"-"+month+"-"+1);
	}
}
