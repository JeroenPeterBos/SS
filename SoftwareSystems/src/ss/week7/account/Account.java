package ss.week7.account;

public class Account {
	protected double balance = 0.0;
	
	

	public synchronized void transaction(double amount) {
		if(amount < 0){
			while(balance + amount < -1000){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		balance = balance + amount;
		if(balance > -1000){
			notify();
		}
		
		System.out.println("balance : " + balance);
	}
	
	public double getBalance() {
		return balance;
	}
}
