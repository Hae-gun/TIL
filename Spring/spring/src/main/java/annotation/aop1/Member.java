package annotation.aop1;

import org.springframework.stereotype.Component;

@Component
public class Member {
	public void login(String id) {
		System.out.println(id + " ȸ������ �α��� �ϼ̽��ϴ�.");
	}

	public void logout() {
		System.out.println("ȸ������ �α׾ƿ� �ϼ̽��ϴ�.");
	}
}
