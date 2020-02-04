package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	 @RequestMapping("/hello") //xml ���� <beans:prop key="/hello">hc</beans:prop> �ǹ�.
	  public ModelAndView handleRequest(HttpServletRequest request,
	  HttpServletResponse response) {
	  System.out.println("HelloController �������Դϴ�.");
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("model", "Hello Spring Annotation"); 
	  mv.setViewName("hello"); //��� view�� �����̵�. ��ð� ������ url�� �Ȱ��� view�� ������.
	  return mv; 
	}

}
