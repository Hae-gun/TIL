package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String loginform() { // 1. ���� �޼ҵ� ����Ÿ���� String�϶� : �ڵ����� View�� �̸��� ��. �𵨾��� �丸 �ʿ��Ҷ� �����.
		// �α����� ���=html�±�=jsp
		// model, view �� �ʿ��ϳ� ���⼱ model�� �ʿ����. view�� ������.

		return "loginform";
	}

	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ModelAndView loginsuccess(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult",true);
		mv.setViewName("loginsuccess");
		return mv;
	}
}
