package empspring;

public class EmpDAO {
//FORM - ������� - DB ���� �޼ҵ�.
// ������� ��ȸ - HTML ������ ���.
	
	EmpVO vo;

	public EmpDAO() {
		System.out.println("EmpDAO ������ ȣ��.");
	}
	
	public void setVo(EmpVO vo) {
		this.vo = vo;
	}

	public void insertEmp() {
//spring ��û - EmpVO ��ü 1�� ����(���� 10000 ������)
		System.out.println(vo.getName() + " ����� "+vo.getSalary()+" �޿��� ������ "+vo.getDeptname()+" �μ��� �ٹ��մϴ�.");
	}
}
