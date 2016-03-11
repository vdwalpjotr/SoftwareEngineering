package assignmentsLiang;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class assigment1a {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.execute(new NumberThread(1));
		executor.execute(new NumberThread(2));
		executor.execute(new NumberThread(3));
		executor.execute(new NumberThread(4));
		
		executor.shutdown();
	}

	public static class NumberThread implements Runnable {
		private int myNumber;
		
		private static Lock lock = new ReentrantLock();
		
		public NumberThread(int number) {
			myNumber = number;			
		}
		
		public void run() {
			lock.lock();
			printNumber();
			lock.unlock();
		}
		
		private void printNumber() {
			System.out.print(myNumber);
			System.out.println(myNumber);
		}
	}

}