package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardlistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 System.out.println("HelloController �������Դϴ�.");
		  ModelAndView mv = new ModelAndView();
		  //board���̺� ��� �Խù� : ArrayList<BoardVO>
		  //���ఴü ����.
		  BoardDAO dao = new BoardDAO();
		  ArrayList<BoardVO> list = dao.getList();
		  mv.addObject("boardlist", list); // request.setAttribute(list) �� �ǹ�.
		  mv.setViewName("boardlist"); 
		  return mv; // DispatcherServlet�� ����.
	}

}
