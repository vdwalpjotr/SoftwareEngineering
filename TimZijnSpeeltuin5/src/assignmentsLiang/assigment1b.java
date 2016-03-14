package assignmentsLiang;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class assigment1b {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.execute(new NumberThread2(1));
		executor.execute(new NumberThread2(2));
		executor.execute(new NumberThread2(3));
		executor.execute(new NumberThread2(4));
		
		executor.shutdown();
	}

	public static class NumberThread2 implements Runnable {
		private static int CURRENT_NUMBER = 4;
		private int myNumber;
		
		private static Lock lock = new ReentrantLock();
		private static Condition nextNumber = lock.newCondition();
		
		public NumberThread2(int number) {
			myNumber = number;			
		}
		
		public void run() {
			lock.lock();
			try {
			while(myNumber < CURRENT_NUMBER) {
					nextNumber.await();
			}
			}
			catch (InterruptedException ex) {
				
			}
			finally {
				printNumber(myNumber);
				CURRENT_NUMBER--;
				nextNumber.signalAll();
				lock.unlock();
			}
		}
		
		private void printNumber(int myNumber) {
			System.out.print(myNumber);
			System.out.println(myNumber);
		}
	}

}