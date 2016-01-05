package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	private static Lock lock = new ReentrantLock();
	
	public TestSyncConsole(String name){
		super(name);
	}
	
	@Override
	public void run(){
		sum();
	}
	
	private synchronized void sum(){
		lock.lock();
		int one = SyncConsole.readInt(getName() + ": get number 1: ");
		int two = SyncConsole.readInt(getName() + ": get number 2: ");
		
		SyncConsole.println(getName() + ": " + one + " + " + two + " = " + (one + two));
		lock.unlock();
	}
	
	public static void main(String[] args){
		new TestSyncConsole("Thread A").start();
		new TestSyncConsole("Thread B").start();
	}
}
