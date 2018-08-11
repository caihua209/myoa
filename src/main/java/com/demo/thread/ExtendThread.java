package com.demo.thread;
/**
 * 继承Thread类来实现线程
 * <p>
 * 	因为Java是单继承的关系，所以，并不推荐使用继承的方式来开发，而是通过下面实现接口的方式来做。
 *  可以避免同时需要继承其它的类
 * </p>
 * @author caish
 * @date 2018年8月7日 
 */
public class ExtendThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	/**
	 * 启动线程
	 */
	public static void startExtThread() {
		ExtendThread extendThread1 = new ExtendThread();
		ExtendThread extendThread2 = new ExtendThread();
		ExtendThread extendThread3 = new ExtendThread();
		extendThread1.setName("1");
		extendThread2.setName("2");
		extendThread3.setName("3");
		
		extendThread1.start();
		extendThread2.start();
		extendThread3.start();
	}
	
	/**
	 * 值得注意的点:
	 *  main方法中按顺序调用三个线程，但并不意味着这三个线程会按照顺序运行，而是通过抢夺资源，
	 *  哪个线程抢到了，就先运行，所以控制台打印的顺序也没有按照启动的顺序来
	 * @param args
	 */
	public static void main(String[] args) {
		// main 方法本身就是一个线程(打印会出现: main)
		System.out.println(currentThread().getName());
		startExtThread();
	}
}
