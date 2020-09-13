package com.github.perschola;

class SharedInt implements Runnable{
	int counter = 0;
	@Override
	public synchronized void run() {
		for (int i = 0; i<1000000; i++) {
			counter++;
		}
		
		System.out.println(Thread.currentThread().getName() + counter);
		
	}
	
}

public class SimpleSchronization {
	public static void main(String[] args) {
		SharedInt shared = new SharedInt();
		Thread t1 = new Thread(shared, "T1: ");
		Thread t2 = new Thread(shared, "T2: ");
		t1.start();
		t2.start();
	}
}
