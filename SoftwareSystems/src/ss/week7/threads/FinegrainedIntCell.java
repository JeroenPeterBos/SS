package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {

	private int value;
	private boolean unconsumed = false;
	
	private Lock lock = new ReentrantLock();
	private Condition readCondition = lock.newCondition();
	private Condition writeCondition = lock.newCondition();
	
	@Override
	public void setValue(int val) {
		try{
			lock.lock();
			if(unconsumed){
				try {
					writeCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.value = val;
			this.unconsumed = true;
			
			readCondition.signal();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int getValue() {
		try{
			lock.lock();
			
			if(!unconsumed){
				try {
					readCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			int res = value;
			this.unconsumed = false;
			
			writeCondition.signal();
			return res;
		} finally {
			lock.unlock();
		}
	}
}
