package aopexam;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAspect {

	public void result(ProceedingJoinPoint jp) {
		Object returnValue;
		try {
			System.out.println("���� ���ɿ� �� �Ծ����?");
			returnValue = jp.proceed();
			System.out.println(returnValue + " �Ծ�����.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void before() {
		System.out.println("���� ���ɿ� �� �Ծ����?");
	}

	public void after(Object ret) { // <aop:after-returning>�� ����ؾ���. input�� object�� �ٰ�.

		System.out.println(ret + " �Ծ�����.");
	}

}
