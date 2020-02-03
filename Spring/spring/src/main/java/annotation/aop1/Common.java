package annotation.aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // <bean id="common" class="Common">
@Aspect // <aop:aspect id="c" ref="common">
public class Common {
	
	@Pointcut("execution (public * annotation.aop1.*.*(..))") //<aop:pointcut expression="public * aop1.*.*(..))" id="pc">
	public void pc() { } //������ �ƹ��͵� �������. abstract �ż��尡 �ƴ�. 
	
	long startTime = System.currentTimeMillis(); // ���� �ð�(1/1000�� ����)
	
	//@Before("pc()") //<aop:before method="a" pointcut-ref="pc"/>
	public void a() { //before
		System.out.println("===�ż��� ȣ��ð�===" + new Date(startTime));
	}
	
	//@After("pc()")
	public void b() { //after
		long endTime = System.currentTimeMillis(); 
		System.out.println("===�޼ҵ����ҿ�ð�(1/1000)===" + (endTime - startTime));
	}
	
	@Around("pc()")
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
