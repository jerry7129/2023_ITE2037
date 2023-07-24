package lab12;

public class Buffer{
	private double[] data;
	private int loc = 0;
	
	public Buffer(int size) { //Buffer Constructor
		data = new double[size];
		System.out.println("New buffer");
		System.out.println(this);
	}
	
	public synchronized String toString() { //data의 정보를 출력
		String toReturn = "";
		for(double d: data) {
			toReturn += String.format("%.2f", d)+" ";
		}
		return toReturn;
	}
	
	public synchronized void add(int num, double toAdd) throws InterruptedException{
		//과제 제출 형식을 지키기 위해서 int num 매개변수 추가함
		
		//////
		/*
		while 대신에 if문을 쓸 경우 예기치 못한 상황에서 wait이 끊기게 된다면 문제가 발생할 수 있다.
		따라서 이를 방지하기 위해 while문을 사용해준다.
		*/
		//////
		while(loc >= data.length) { //data 길이보다 loc가 같거나 클 경우 매세지 출력과 함께 현재 쓰레드 일시 정지
			System.out.println("Producer#"+num+" @ Buffer is full.\n");
			wait();
		}
		//data에 정보를 추가하고 나머지 쓰레드를 실행 대기 상태로 전환
		System.out.println("Producer#"+num+" Adding item on "+loc+": "+toAdd);
		data[loc++] = toAdd;
		System.out.println(this);
		System.out.flush();
		notifyAll();
	}
	
	public synchronized double remove(int num) throws InterruptedException{
		//과제 제출 형식을 지키기 위해서 int num 매개변수 추가함
		//////
		/*
		while 대신에 if문을 쓸 경우 예기치 못한 상황에서 wait이 끊기게 된다면 문제가 발생할 수 있다.
		따라서 이를 방지하기 위해 while문을 사용해준다.
		*/
		//////
		while(loc <= 0) { //loc가 0 이하일 경우 매세지 출력과 함께 현재 쓰레드 일시 정지
			System.out.println("Consumer#"+num+" 0 Buffer is empty.\n");
			wait();
		}
		//data의 정보를 0으로 초기화하고 나머지 쓰레드를 실행 대기 상태로 전환
		double hold = data[--loc];
		System.out.println("Consumer#"+num+" Removing item on "+loc+": "+hold);
		data[loc] = 0.0;
		System.out.println(this);
		System.out.flush();
		notifyAll();
		return hold;
	}
	
	public synchronized int getSize() {
		return data.length;
	}
}
