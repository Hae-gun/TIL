package annotation.aopexam;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public String lunch() {
		System.out.println("��Ḧ �Ծ����ϴ�.");
		return "������-���";
	}

}
