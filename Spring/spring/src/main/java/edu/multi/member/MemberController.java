package edu.multi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//ȸ�����Ա��. �˾Ƽ� �ۼ�
	@Autowired
	MemberDAO dao;
	//�α��α��.
	
		@RequestMapping(value = "/session/insertmember", method=RequestMethod.GET)
		public String insertform() {
			return "mybatis/insertmember";
		}
		
		@RequestMapping(value = "/session/insertmember", method=RequestMethod.POST)
		public String insertprocess(MemberVO vo) {
			
			if(dao.checkMember(vo)==null) {
				dao.insertMember(vo);
				return "mybatis/successinsert";
				}
			else
				return "mybatis/inserterror";
			
			
		}
		
	
		@RequestMapping("/session/login")
		public String loginform() {
			return "mybatis/login"; //�α��� �� �����ִ� â.
		}
		@RequestMapping("/session/loginprocess")//db member ���̺� ���� - ���� ����.
		public String loginprocess(HttpServletRequest request, String userid, String password) { //�α��� ������ �Է¹��� ������ ó��
			//ModelAndView mv = new ModelAndView();
			MemberVO vo = dao.selectMember(userid,password);
			//mv.addObject("member",vo);//1�� �� (mvc)
			//mv.setViewName("mybatis/loginprocess");
			HttpSession session = request.getSession();
			session.setAttribute("member", vo);
			return "mybatis/loginprocess";
		}
		@RequestMapping("/session/mypage")
		public String getMyPage() {
			// session�� ���� ������� ���� ������ ������ ���̸� �������� ������� �ʴ� �� ��� ����� �����ϴ�.
			return 	"mybatis/mypage";
		}
		@RequestMapping("/session/logout")
		public String logout(HttpSession session) {
			//�������� �����. HttpSession ��ü ���� ���� ����.
			//HttpSession session = request.getSession();
			//session.removeAttribute("member");
			return "mybatis/logout";
		}
		
	//�α׾ƿ����.
}
