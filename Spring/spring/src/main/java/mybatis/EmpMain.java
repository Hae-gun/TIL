package mybatis;

//������ ���� ���� ����/jsp ��ü ���� : session(HttpSessionŸ��)
//spring mvc : session ���� ������� ���.

//mybatis : SqlSessionŸ��. ������ �ٸ� session(jdbc Connection�� ����) (session�� �⺻ �����̶�� �ǹ̷� ���´�.)

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {

		// 1.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 2. SqlSessionFactory = ���� �������� �о��.
		// sql ���� ���ϸ�.
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		// 3. SqlSession = jdbc Connection ���� SqlSession = ���� ����.
		SqlSession session = factory.openSession(true);
		// mybatis�� �ڵ����� Ʈ����� ó�� ����.(commit ������.)
		System.out.println(session.getConnection().getAutoCommit());// null�̸� ��������.
/////////////////��������� ���� ����.
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);

		// test1
//		List<EmpVO> list = dao.getAllEmp();
//		for (EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + " : " + vo.getFirst_name());
//		}
//		// test2
//		EmpVO vo = dao.getOneEmp(200);
//		System.out.println(vo.getEmployee_id()+" : "+vo.getFirst_name());
//		// test3
//		List<EmpVO> list = dao.getNameEmp("Steven");
//		for(EmpVO data:list) {
//			System.out.println(data.getEmployee_id() + " : " + data.getFirst_name());
//		}
		//test4
//		List<EmpVO> list = dao.getIdEmp();
//		for (EmpVO data : list) {
//			System.out.println(data.getEmployee_id() + " : " + data.getFirst_name() + "---" + data.getHire_date());
//		}
		//test5 : ���ο� ��� ���. : insert sql ���� ����.
		// 1000, ȫ, gil@multi.com, sysdate, 'IT_PROG' 
		// insert into employees(employee_id,last_name,email,hire_date,job_id) values(1000,'ȫ','email',sysdate,'IT_PROG') 
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(1002); // �ߺ� �Ұ���
//		vo.setFirst_name("�浿");
//		vo.setLast_name("ȫ");
//		vo.setEmail("gil2@multi.com"); // �ߺ� �Ұ���
//		vo.setJob_id("IT_PROG");//SQL Ű����� ��ҹ��ڱ���X(���� ��ҹ��� ����.)
		
		//DML���� insert/delete/update/
//		dao.insertEmp(vo);//insert�� ����
//		System.out.println("�űԻ�����");
		//test6 : 1001 ��� �̸� ��õ, �̸��Ϻ��� hong@multi.com
		//<update id="updateemp" parameterType="emp">
		//update employees set first_name = #{}, email = #{} where employee_id = #{}
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(1001);
//		vo.setFirst_name("��õ");
//		vo.setEmail("hong@multi.com");
//		int row = dao.updateEmp(vo);
//		System.out.println(row + "���� ���ڵ� �����Ϸ�");
		//test7: ���� 1001�� ��� ����.
		// delete employees where first_name like 'ȫ%'
//		int id = 1001;
//		int row = dao.deleteEmp(id);
//		System.out.println(row+"�� �� ����");
		
		//test8 �������� 10�� ���.
		int pagenum = 2;
		int cnt = 10;
		int param[] = new int[2];
		param[0] = (pagenum-1)*cnt+1;
		param[1] = pagenum*cnt;
		List<EmpVO> list = dao.pagingEmp(param);
		for(EmpVO vo : list) {
			System.out.println(vo.getFirst_name()+" : "+vo.getHire_date());
		}
	}

}
