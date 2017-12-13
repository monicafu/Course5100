package INFO5100.Assignment7;


/**Question 2: 
 * create threads that generate other threads, from 1 up to Thread 50
 * print "Hello from Thread num" in reverse order
 * */
public class ReverseHello extends Thread{ // score 2
	
	private static final int MAX_NUM = 50;
	private static final int START_NUM = 1;
	private int count;
	

	private ReverseHello(int count) {
		this.count = count;
	}

	public static void main(String[] args) {	 
			ReverseHello rh1 = new ReverseHello(START_NUM);
			rh1.start();
	}

	@Override
	public void run() {
		try {
			if (count <= MAX_NUM) {
				generateThread(count++);
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void generateThread(int count) throws InterruptedException {		
		ReverseHello rh = new ReverseHello(this.count);	
		rh.start();
		rh.join();
		printHello(this.count-1);
	}

	private void printHello (int threadNum) {
		System.out.println("Hello from Thread - "+ threadNum);
	}
}
