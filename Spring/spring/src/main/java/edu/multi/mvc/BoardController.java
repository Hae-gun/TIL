package edu.multi.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController  {
	@Autowired// 1.<beans:bean id="dao" class="xxx.BoardDAO.class"> 2. @Repository("dao") class BoardDAO
	BoardDAO dao;
	
	@RequestMapping("/boardlist")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 System.out.println("HelloController �������Դϴ�.");
		  ModelAndView mv = new ModelAndView();
		/* BoardDAO dao = new BoardDAO(); */ 
		  ArrayList<BoardVO> list = dao.getList();
		  mv.addObject("list", list); 
		  mv.setViewName("boardlist"); 
		  return mv; 
	}
	
////	1�� �Խù� ��ȸ.
//	@RequestMapping("/boarddetail")
//	public ModelAndView boardDetail(@ModelAttribute("vo") BoardVO vo) {
//		ModelAndView mv = new ModelAndView();
//		dao.getDetail(vo.getSeq());
//		return mv;
//	} 
//	1�� ���ù� �ۼ�.
//	1�� �Խù� �۾��� �� ȭ��
	@RequestMapping(value = "/boardinsert", method=RequestMethod.GET)
	public String insertBoardForm() {
		return "boardinsertform";
	}
	//�۾� �������޹޾Ƽ� board ���̺� ����.
	@RequestMapping(value = "/boardinsert", method=RequestMethod.POST)
	public String insertBoardResult(@ModelAttribute("vo")BoardVO vo) {
//		BoardDAo ��ü insertBoard(vo) ����.
//		System.out.println(vo.getTitle());
		int result = dao.insertBoard(vo);
		if(result==1) {
			System.out.println("���� insert");
		}else {
			System.out.println("������ insert");
		}
		return "redirect:/boardlist";
	}
	//1�� �Խù� ����
	@RequestMapping(value="/boardupdate", method = RequestMethod.GET)
	public String updateBoardForm() {
		
		return "updateboardform";
	}
	@RequestMapping(value="/boardupdate", method = RequestMethod.POST)
	public String updateBoard() {
		
		return "redirect:/boardlist";
	}
	//1�� �Խù� ����
	@RequestMapping(value = "/boarddelete", method=RequestMethod.GET)
	public String deleteBoardForm() {
		return"deleteboardform";
	}
	@RequestMapping(value = "/boarddelete", method=RequestMethod.POST)
	public String deleteBoard(int seq) {
		System.out.println("deleteBoard �������Դϴ�.");
		int result = dao.deleteBoard(seq);
		if(result==1) {
			System.out.println("���� delete");
		}else {
			System.out.println("������ delete");
		}
		return "redirect:/boardlist";
	}
	
	
}
