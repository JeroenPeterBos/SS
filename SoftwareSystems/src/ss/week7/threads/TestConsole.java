package ss.week7.threads;

public class TestConsole extends Thread{
	
	public TestConsole(String name){
		super(name);
	}
	
	@Override
	public void run(){
		sum();
	}
	
	private void sum(){
		int one = Console.readInt(getName() + ": get number 1: ");
		int two = Console.readInt(getName() + ": get number 2: ");
		
		Console.println(getName() + ": " + one + " + " + two + " = " + (one + two));
	}
	
	public static void main(String[] args){
		new TestConsole("Thread A").start();
		new TestConsole("Thread B").start();
	}
}
