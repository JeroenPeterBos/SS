package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedIntCell implements IntCell{

	private int value = 0;
	private boolean unconsumed = false;

	public synchronized void setValue(int valueArg) {
		if(unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.value = valueArg;
		this.unconsumed = true;
		notify();
	}

	public synchronized int getValue() {
		
		if(!unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.unconsumed = false;
		int res = this.value;
		
		notify();
		return res;
	}
}
