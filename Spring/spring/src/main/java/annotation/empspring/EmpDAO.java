package annotation.empspring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmpDAO {
//FORM - ������� - DB ���� �޼ҵ�.
// ������� ��ȸ - HTML ������ ���.
	
	
	@Autowired
	EmpVO vo;

	public EmpDAO() {
		System.out.println("EmpDAO ������ ȣ��.");
	}
	
	

	public void insertEmp() {
//spring ��û - EmpVO ��ü 1�� ����(���� 10000 ������)
		System.out.println(vo.getName() + " ����� "+vo.getSalary()+" �޿��� ������ "+vo.getDeptname()+" �μ��� �ٹ��մϴ�.");
	}
}
