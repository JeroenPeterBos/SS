package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedIntCell implements IntCell{

	private int value = 0;
	private boolean unconsumed = false;
	
	private static ReentrantLock writersLock = new ReentrantLock();
	private static ReentrantLock readersLock = new ReentrantLock();

	public synchronized void setValue(int valueArg) {
		writersLock.lock();
		if(unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.value = valueArg;
		unconsumed = true;
		writersLock.unlock();
	}

	public synchronized int getValue() {
		readersLock.lock();
		int res = value;
		unconsumed = false;
		notify();
		readersLock.unlock();
		return res;
	}
}
