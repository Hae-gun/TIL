package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Command ���� �����.(Interface Orverriding)
public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController �������Դϴ�.");
		
		// servlet ---> jsp ������ ����, ����
		request.setAttribute("model", "Hello Spring"); //(or session.setAtrribute) (�̸�, ��) "model"�̶�� ���� ���޹��� ����
		return "/hello.jsp";/* ����� view�� �̸��� ����*/
		//������ --> request.getAttribute("model");
		//or ${model}
	}

}
