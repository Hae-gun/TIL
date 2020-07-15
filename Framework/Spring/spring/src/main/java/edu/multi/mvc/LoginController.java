package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String loginform() { // 1. ���� �޼ҵ� ����Ÿ���� String�϶� : �ڵ����� View�� �̸��� ��. �𵨾��� �丸 �ʿ��Ҷ� �����.
		// �α����� ���=html�±�=jsp
		// model, view �� �ʿ��ϳ� ���⼱ model�� �ʿ����. view�� ������.

		return "loginform";
	}

	// <form action="" method=POST>
	// �� �Է� ���� ���޹޾Ƽ� ó��.
	// ��û��� post : �ѱ� ������ ����.
//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginsuccess(HttpServletRequest request) {//parameter�� ������ Request���� �ʿ���. Servlet��û
//	 request.setCharacterEncoding("UTF-8"); // �̹� xml�� �ۼ��ߴ�.
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		// id pw �Է� ���� ����
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//
//		// id, pw - db member���̺� ���� ����.
//		// id spring �̰� pw spring �� ���� �α��λ��� : true
//		ModelAndView mv = new ModelAndView();
//
//		if (id.equalsIgnoreCase("spring") && pw.equalsIgnoreCase("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginsuccess(@RequestParam(value="id",required = true, defaultValue="spring")
//	String id2, String pw, int age) { //id2 ���� ��û�Ķ���� id �ڵ�����.
//		
//// 		form input name="id" : Ŭ���̾�Ʈ�� ��û�Ķ���� �̸� id�� �����Ѵ�.
//// 		��û�Ķ�����̸��� ��Ʈ�ѷ� �޼ҵ� �Ű����� �̸��� �����ϸ� �ڵ����� ������.		
////		form �Է� name �� = �Ű����� �̸� ���� => db �÷��� ���� ����. 3���� ���ߴ°��� ����.
//		ModelAndView mv = new ModelAndView();
//
//		if (id2.equalsIgnoreCase("spring") && pw.equalsIgnoreCase("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginsuccess(@ModelAttribute("login") LoginVO vo) { 
//		
//		//��û�Ķ�����̸��� ��Ʈ�ѷ� �޼ҵ� �Ű����� �ڹٰ�ü�϶�.
//		//��ü ���� ��������� �̸� ���� �ڵ� ����.
//		//get�޼��� ���.
////		��Ʈ�ѷ� �޼ҵ� �ŰԺ��� ��ü�� �� �ڵ� �����·� ����.
////		 �� �̸�("",???) �� �̸��� �ڵ����� ������. : LoginVO -> loginVO�� ����. (�� �ձ��� �빮�ڸ� �ҹ��ڷ� �ٲ�.)\
////		 mv.addObject("loginVO", vo);�� ���� �ǹ�.
//		ModelAndView mv = new ModelAndView();
//		
//		if (vo.getId().equalsIgnoreCase("spring") && vo.getPw().equalsIgnoreCase("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//		
//		mv.setViewName("loginsuccess");
//		return mv;
//	}

}
