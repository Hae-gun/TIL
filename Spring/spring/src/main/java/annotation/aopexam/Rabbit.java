package annotation.aopexam;

import org.springframework.stereotype.Component;

@Component
public class Rabbit implements Animal {

	@Override
	public String lunch() {
		System.out.println("����� �Ծ����ϴ�.");
		return "�䳢-���";
	}

}
