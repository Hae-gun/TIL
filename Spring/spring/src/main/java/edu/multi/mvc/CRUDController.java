package edu.multi.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	Map<String, String> members = new HashMap<String, String>();

//ȸ������
	// http://ip:port/���ؽ�Ʈ��/crud/start
	@RequestMapping("/crud/start")
	public void start() { // void�ϋ��� �� ������ �͵� ���ٴ� �ǹ�.
		// ��������� �� �̸��� ����ϸ� �� �̸��� ��. �� �̸��� ��þȵǾ� �ִٸ� �ڵ����� url �̸��� �����ϰ� �並 ����.
		System.out.println("====Ȩ������ ùȭ���Դϴ�.====");
		members.put("spring", "����");
		members.put("oracle", "�̴븮");
		members.put("mybatis", "�ְ���");
		// return "crud/start"; // view�� start.jsp�� �ٰ�. ���ʰ��� �Ҷ� : crud�������� start.jsp��
		// �ν�.
	}

	@RequestMapping("/crud/list")
	public ModelAndView list() {
		// ��� ȸ������
		// Model -- ��Ʈ�ѷ����� jsp ���� ��� ������.
		ModelAndView mv = new ModelAndView();
		mv.addObject("members", members);
		// �� �̸� �������ϸ� �ڵ����� RequestMappling�� mapping url �� ������.
		return mv;
	}

	@RequestMapping("/crud/get")
	public ModelAndView get(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = members.get(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("member", id + ":" + name);
		return mv;
	}

	@RequestMapping("/crud/add")
	public void add() {
		// "new" "���Ի��" members�߰�. - crud/add.jsp
		members.put("new", "���Ի��");
	}

	@RequestMapping("/crud/update")
	public Map<String, String> update() { //ù��° ��Ʈ�� : ���̸�, �ι�° ��Ʈ�� : �𵨰�.
		Map<String, String> informs = new HashMap<String, String>();
		informs.put("id","������ id�� �Է��ϼ���");
		informs.put("name","������ �̸��� �Է��ϼ���");
		informs.put("email","�̸��� ����� xxx@yyy.com �����Դϴ�.");
		informs.put("idvalue","spring");
		//${id}
		return informs; // �ڵ����� 3���� �𵨸���. 
		//view�� ��ð� ������ �ڵ����� url�� ������. .../crud/update.jsp
	}

	@RequestMapping("/crud/delete")
	public String delete() {
		// "new" ���̵� members���� ����.
		members.remove("new");
		return "redirect:/crud/list"; // redirect:��Ʈ�ѷ� ���� list()�޼ҵ� ������ �� �ż��� ��� ��� �ٷ��̵��϶�� �ǹ�.;

	}
//	 
}
