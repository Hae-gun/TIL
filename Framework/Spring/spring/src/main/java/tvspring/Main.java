package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// TVFactory--> ���������� ����.
		ApplicationContext factory = new ClassPathXmlApplicationContext("tvspring/tv.xml");
		TV tv = factory.getBean("tv", TV.class); // ��ӹ��� �������̽��� ����ȯ ����.
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		TV tv2 = factory.getBean("tv2", TV.class); // ��ӹ��� �������̽��� ����ȯ ����.
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
	}

}
