package ss.week7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcatThread extends Thread {
    public static String text = ""; // global variable
    private static Lock textLock = new ReentrantLock();
    private String toe;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public void run() { // critical
    	textLock.lock();
        text = text.concat(toe);
        textLock.unlock();
    }
    
    // possible values: "one;" , "two;" , "one;two;" or "two;one;";

    public static void main(String[] args) {
        Thread a = new ConcatThread("one;");
        Thread b = new ConcatThread("two;");
        
        a.start();
        try {
			a.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        b.start();
        
        try {
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(ConcatThread.text);
    }
}
