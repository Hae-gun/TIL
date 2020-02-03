package annotation.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/aop1/aop.xml");
		Member m = factory.getBean("member",Member.class);
		Board b = factory.getBean("board",Board.class);
		
		//������� = Ⱦ�ܰ��� = aspect Ŭ����.
		//Common c = factory.getBean("common", Common.class); Spring�� ���鿹��.
		
		//ȣ��ð�
		m.login("spring");
		//ȣ��ð�
		b.inserBoard(100);
		//ȣ��ð�
		b.getList();
		//ȣ��ð�
		m.logout();
	}

}
