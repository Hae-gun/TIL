package annotation.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {

	@Pointcut("execution (public * annotation.aopexam.*.*(..))")
	public void pc() {
	}

	@Around("pc()")
	public Object result(ProceedingJoinPoint jp) { // Around �ż��忡 return���� �־� ���� �޾ƿü� ����. ������ null�� return.
		Object returnValue=null;
		try {
			System.out.println("���� ���ɿ� �� �Ծ����?");
			returnValue = jp.proceed();
			System.out.println(returnValue + " �Ծ�����.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
		
	}
	//@Before("pc()")
	public void before() {
		System.out.println("���� ���ɿ� �� �Ծ����?");
	}
	//@AfterReturning("pc()") //Around�� AfterReturning ���� ���ÿ� ����� �Ұ����ϴ�.
	public void after(Object ret) { // <aop:after-returning>�� ����ؾ���. input�� object�� �ٰ�.

		System.out.println(ret + " �Ծ�����.");
	}
}
