package ss.week7.account;

public class AccountSync {

	public static void main(String[] args){
		Account account = new Account();
		
		Thread a = new MyThread(-100.0, 1000, account);
		Thread b = new MyThread(100.0, 1000, account);
		
		a.start();
		b.start();
		
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance());
	}
}
