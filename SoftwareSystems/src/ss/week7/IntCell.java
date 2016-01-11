package ss.week7;

public class IntCell {
    private int contents = 0;

    public synchronized void add(int amount) {
        contents = contents + amount;
    }
    public synchronized int get() {
        return contents;
    }

    public static void main(String[] args) {
        IntCell cell = new IntCell();
        Adder a1 = new Adder(cell, 1);
        Adder a2 = new Adder(cell, 2);
        a1.start();
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

// 7.20.1:		1, 2, 3
// 7.20.2:		3 omdat het programma nu sequentieel is
// 7.20.3:		0, 1, 2, 3
// 7.20.4:		3 omdat 2 mogelijkheden --> 0 + 1 + 2 = 3 || 0 + 2 + 1 = 3

class Adder extends Thread {
    private IntCell cell;
    private int amount;

    public Adder(IntCell cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public void run() {
        cell.add(amount);
    }
}
