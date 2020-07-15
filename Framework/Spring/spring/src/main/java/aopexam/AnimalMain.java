package aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopexam/animal.xml");
		
		Animal [] ani = new Animal[3]; //�������̽��� �迭 ������ ����.
//		Animal ani = new Animal(); �������̽��� ��ü������ �Ұ���.
		ani[0] = (Animal)factory.getBean("cat");
		ani[1] = factory.getBean("dog", Animal.class);
		ani[2] = factory.getBean("rabbit", Animal.class);
		
		for(Animal A: ani) {
			A.lunch();
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
 