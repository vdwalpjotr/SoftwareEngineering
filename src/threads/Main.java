package threads;
import java.util.concurrent.locks.*;

public class Main {
	public static void main(String[] args){
		Lock lock = new ReentrantLock();
		Runnable printOne = new PrintNumber(1, lock);
		Runnable printTwo = new PrintNumber(2, lock);
		Runnable printThree = new PrintNumber(3, lock);
		Runnable printFour = new PrintNumber(4, lock);
		
		Thread t1 = new Thread(printOne);
		Thread t2 = new Thread(printTwo);
		Thread t3 = new Thread(printThree);
		Thread t4 = new Thread(printFour);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
