package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
	// web.xml:'/' -> FrontControllerServlet
	// ��� ��û FrontControllerServlet
	/* @WebServlet("/front") */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> FrontControllerservlet</h1>"); // FrontController���� : ��� ��û�� �ϳ��� Controller�� �����ϱ� ���� ����.
															// Spring���� ����ϴ� ����.
		out.println(request.getRequestURL());
		out.println(request.getRequestURI());
		String s[] = request.getRequestURI().split("/");
		out.println("<h1>" + s[s.length - 1] + "</h1>");
		// 3. hello - �� ��Ű��( MVC ) --> SPRING ����ȯ�� ���� ����.
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(s[s.length - 1]);
		String viewname = controller.handleRequest(request, response); // model�̸����� "Hello Spring" ���ڿ��� ���� hello.jsp �� ��������
		
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);//(��û����, ���亯��)
	}

}
