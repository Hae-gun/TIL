package annotation.aopexam;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

	@Override
	public String lunch() {
		System.out.println("������ �Ծ����ϴ�.");
		return "����-����";
	}
	
	

}
