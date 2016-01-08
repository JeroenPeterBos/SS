package ss.week7.threads;

public class SynchronizedIntCell implements IntCell{

	private int value = 0;
	private boolean unconsumed = false;

	public synchronized void setValue(int valueArg) {
		while(unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.value = valueArg;
		this.unconsumed = true;
		notifyAll();
	}

	public synchronized int getValue() {
		
		while(!unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.unconsumed = false;
		int res = this.value;
		
		notifyAll();
		return res;
	}
}
