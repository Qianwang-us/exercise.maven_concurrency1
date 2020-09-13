package com.github.perschola;

public class CreatingAndJoining extends Thread{
	public CreatingAndJoining(String s) {
		super(s);
	}
	public CreatingAndJoining() {}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":  Hello World");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread hello = new CreatingAndJoining();
		hello.start();
		
		Thread[] threads = new Thread[5];
		
		for(int i=0; i<threads.length; i++) {
			threads[i] = new CreatingAndJoining("Thread["+i+"]");
			threads[i].start();
			threads[i].join();
		}
	}
}
