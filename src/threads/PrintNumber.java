package threads;

import java.util.concurrent.locks.*;

public  class PrintNumber implements Runnable{
	private int number;
	public static int next;
	private static Lock lock;
	private static Condition largerFirst;
	public PrintNumber(int n, Lock lock){
		this.lock = lock;
		largerFirst = lock.newCondition();
		number = n;
		next = 4;


	}

	public void run() {

		
			lock.lock();

			try{
				while(number < next){

					largerFirst.await();
				}
				
					
			}catch(InterruptedException IE){
				IE.printStackTrace();
			}finally{
			
			System.out.print(number);
			System.out.print(number+"\n");

			next--;
			largerFirst.signalAll();
			lock.unlock();
			}
		
	}
}


