package lab03;

public class Staff {
	
	private String name, department;
	private int age, workDays, vacationDays;
	
	public Staff(String name, int age) {
		this.name = name;
		this.age = age;
		department = "None";
		workDays = 0;
		vacationDays = 20;
	}
	public Staff(String name, int age, String department, int workDays, int vacationDays) {
		this.name = name;
		this.age = age;
		this.department = department;
		this.workDays = workDays;
		this.vacationDays = vacationDays;
	}
	
	
	public String getter() {
		return name;
	}
	public void setter(Staff s) {
		this.department = s.department;
		this.workDays = s.workDays;
	}
	public boolean sameCareer(Staff s) {
		if(this.department.equals(s.department) && this.workDays == s.workDays)
			return true;
		return false;
	}
	public String toString() {
		String str = "Name: ";
		str += name;
		str += ", Age: ";
		str += age;
		str += ", Department: ";
		str += department;
		str += ", workDays: ";
		str += workDays;
		str += ", VacationDays: ";
		str += vacationDays;
		return str;
	}
	public void vacation(int days) {
		if(days > vacationDays)
			System.out.println(name+", 남은 휴가 일 수 부족.");
		else {
			vacationDays -= days;
			System.out.println(name+", 휴가 "+days+" 사용. 남은 휴가 일수: "+vacationDays);
		}
	}
}
