package lab12;

public class ProdCons{
	private Buffer buffer;
	private Producer[] producer;
	private Consumer[] consumer;
	
	public ProdCons() { //buffer 5개 생성 후 producer 2개와 consumer 2개 생성
		buffer = new Buffer(5);
		producer = new Producer[2];
		consumer = new Consumer[2];
		
		producer[0] = new Producer(buffer);
		consumer[0] = new Consumer(buffer);
		
		producer[1] = new Producer(buffer);
		consumer[1] = new Consumer(buffer);
		//for문으로 생성했을 때와 그냥 생성했을 때 출력이 다르게 나옴
		/*
		for(int i=0; i<2; i++) {
			producer[i] = new Producer(buffer);
			consumer[i] = new Consumer(buffer);
		}*/
	}
	
	private class Producer extends Thread { //Producer inner class
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		public Producer(Buffer buffer) { //Producer 생성자
			this.pNum = serial++;
			this.buffer = buffer;
		}
		
		public void produce() throws InterruptedException{ //buffer의 크기만큼 난수 add
			for(int i=0; i<buffer.getSize(); i++) {
				System.out.println("Producer#"+this.pNum+":"+this);
				buffer.add(this.pNum, Math.random()*100);
			}
		}
		
		public void run() { //produce 실행
			try {
				produce();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class Consumer extends Thread {
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		public Consumer(Buffer buffer) { //Consumer 생성자
			this.pNum = serial++;
			this.buffer = buffer;
		}
		
		public void consume() throws InterruptedException{ //buffer 크기만큼 난수 제거
			for(int i=buffer.getSize(); i>0; i--) {
				System.out.println("Consumer#"+this.pNum+":"+this);
				buffer.remove(this.pNum);
			}
		}
		
		public void run() { //consume 실행
			try {
				consume();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startThread() { //producer와 consumer 실행
		/*for(int i=0; i<2; i++) { //for문을 쓰냐 안 쓰냐에 따라 출력이 다름
			producer[i].start();
			consumer[i].start();
		}*/
		producer[0].start();
		consumer[0].start();
		producer[1].start();
		consumer[1].start();
	}
}
