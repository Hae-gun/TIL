package annotation.aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/aopexam/animal.xml");
		
		Animal [] ani = new Animal[3]; //�������̽��� �迭 ������ ����.
//		Animal ani = new Animal(); �������̽��� ��ü������ �Ұ���.
		ani[0] = (Animal)factory.getBean("cat");
		ani[1] = factory.getBean("dog", Animal.class);
		ani[2] = factory.getBean("rabbit", Animal.class);
		
		
		for(Animal A: ani) {
			String s = A.lunch(); //aspect-around �Ϻ� - lunch - around ������(�� ��԰� ����.)
			System.out.println(s); //null �� ��µ�.(Aspect ���� Around�޼ҵ��� ����Ÿ���� �����ؾ���.)
		}
		
	}

}


/*���� ���ɿ� �� �Ծ����?
 * ������ �Ծ����ϴ�.
 * ����-���� �Ծ�����.
/*���� ���ɿ� �� �Ծ����?
��Ḧ �Ծ����ϴ�.
 * ������-��� �Ծ�����.
/*���� ���ɿ� �� �Ծ����?
����� �Ծ����ϴ�. �� ���� ��� �������� �����.
 * �䳢-��� �Ծ�����.
 * */
 