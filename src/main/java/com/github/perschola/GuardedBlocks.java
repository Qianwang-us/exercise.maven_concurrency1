package com.github.perschola;

public class GuardedBlocks{
	int counter = 0;
	static volatile boolean isFinished = false;
	
	public static void main(String[] args) {
		GuardedBlocks g = new GuardedBlocks();
		
		Thread inc = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				g.incrementValue();
			}

			g.setFinished(true);
		});
		
		Thread print = new Thread(() -> {
			while(!g.isFinished) {
				
			}
			g.printValue();
		});
		
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


