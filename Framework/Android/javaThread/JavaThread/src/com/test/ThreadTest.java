package com.test;

class MyThread extends Thread{
	// �������� ���� �帧�� �־�� �Ѵ�.
	// method�� �������� �����帧�� ǥ���Ѵ�.
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread �Դϴ�.");
	}
}
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("MyThread2 �Դϴ�.");
	}
}

public class ThreadTest {

	// ���α׷��� entry point
	// ���α׷��� �ش� ���α׷����� ���Ǵ� ��� Thread�� ����Ǵ� ������ ���α׷��� ����ȴ�.
	// Java���� Thread�� ��� ǥ���ǳ���? ==> instance(��ü)
    // Thread�� ����� ���� Class�� �����Ѵ�. => Thread class
	// Thread Ŭ������ �̿��ؼ� thread��ü�� �����ϴµ� ũ�� 2���� ������� �����Ѵ�.
	// 1. ���
	// 2. interface�� ����
	
	public static void main(String[] args) {
		
	    Thread t = new MyThread();	// t: thread instance
	    MyRunnable runnable = new MyRunnable();
	    Thread t1 = new Thread(runnable); // ���ڷ� �־ Thread����.
	    // thread�� �����Ű���� start() method�� ���.
	    t.start(); // non blocking method
	    t1.start();
	    System.out.println("Thread�� ���ؼ� �˾ƺ��ƿ�.");
	}

}
