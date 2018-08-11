package com.demo.thread;
/**
 * 实现Runnable接口来实现线程
 * 推荐使用
 * @author caish
 * @date 2018年8月11日 
 */
public class ImplementThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	/**
	 * 启动线程
	 */
	public static void startExtThread() {
		Thread implementThread1 = new Thread(new ImplementThread());
		Thread implementThread2 = new Thread(new ImplementThread());
		Thread implementThread3 = new Thread(new ImplementThread());
		implementThread1.setName("1");
		implementThread2.setName("2");
		implementThread3.setName("3");
		
		implementThread1.start();
		implementThread2.start();
		implementThread3.start();
	}
	
	/**
	 * 值得注意的点:
	 *  main方法中按顺序调用三个线程，但并不意味着这三个线程会按照顺序运行，而是通过抢夺资源，
	 *  哪个线程抢到了，就先运行，所以控制台打印的顺序也没有按照启动的顺序来
	 * @param args
	 */
	public static void main(String[] args) {
		startExtThread();
	}
}
