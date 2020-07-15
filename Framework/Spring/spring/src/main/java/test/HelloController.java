package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override 
	  public ModelAndView handleRequest(HttpServletRequest request,
	  HttpServletResponse response) {
	  System.out.println("HelloController �������Դϴ�.");
	  ModelAndView mv = new ModelAndView();
	  //Controller ---> jsp ������ ���� = ���� = Model(�信 ������ ������) : ���
	  mv.addObject("model", "Hello Spring"); // Model Setting
	  mv.setViewName("hello"); // View Setting (Ȯ���� ���� �ۼ�.)
	  return mv; 
	}

}
