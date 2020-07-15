package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long startTime = System.currentTimeMillis(); // ���� �ð�(1/1000�� ����)
	
	public void a() { //before
		System.out.println("===�ż��� ȣ��ð�===" + new Date(startTime));
	}
	
	public void b() { //after
		long endTime = System.currentTimeMillis(); 
		System.out.println("===�޼ҵ����ҿ�ð�(1/1000)===" + (endTime - startTime));
	}
	
	public void c(ProceedingJoinPoint joinpoint) { //around : before + after
		try {
			System.out.println("�޼ҵ��������");
			Object returnvalue = joinpoint.proceed(); // pointcut ���� ���� �ٽɰ��� �޼ҵ� ����.
			System.out.println("���ϰ�= "+returnvalue);
			
			System.out.println(""+joinpoint.getTarget());
			System.out.println(""+joinpoint.getArgs());
			System.out.println(""+joinpoint.toLongString());
			
			System.out.println("�޼ҵ��������");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
	}
}
