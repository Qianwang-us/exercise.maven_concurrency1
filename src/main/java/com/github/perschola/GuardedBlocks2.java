package com.github.perschola;

public class GuardedBlocks2 extends Thread{
	int counter = 0;
	static volatile boolean isFinished = false;
	Thread inc = new Thread(() -> {
		for (int i = 0; i < 1000000; i++) {
			incrementValue();
		}

		setFinished(true);
	});
	
	Thread print = new Thread(() -> {
		while(!isFinished) {
			
		}
		printValue();
	});
	
	
	public static void main(String[] args) {
		GuardedBlocks2 g = new GuardedBlocks2();
		g.start();
	}
	
	@Override
	public void run() {
		inc.start();
		print.start();
	}
	

	void incrementValue() {
		counter++;
	}

	void printValue() {
		System.out.println(counter);
	}

	

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

} // GuardedBlocks


