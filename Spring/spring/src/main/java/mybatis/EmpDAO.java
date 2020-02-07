package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	// test1 : ������ ���ڵ� ���� ��ȸ.
	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("allemp");// session.selectxxx
		return list;
	}


	// test2 : �Ѱ� ���ڵ� ���� ��ȸ.
	public EmpVO getOneEmp(int id) {
		EmpVO vo = session.selectOne("oneemp", id);// session.selectxxx
		return vo;
	}
//		

	// test3 : �ڿ� parameter �߰�
	public List<EmpVO> getNameEmp(String name) {
		List<EmpVO> list = session.selectList("nameemp", name);// session.selectxxx
		return list;
	}
//	

	// test4: �ε�ȣ ����� sql ���� ���� (cdata ���� ����)
	public List<EmpVO> getIdEmp() {
		List<EmpVO> list = session.selectList("idemp");// session.selectxxx
		return list;
	}
	//insert�� ������ ���� ����.
	public void insertEmp(EmpVO vo) {
		//<insert id="newemp" parameterType="emp"> insert...</insert>
		session.insert("newemp", vo);
	}
	public int updateEmp(EmpVO vo) {
		int row = session.update("updateemp",vo); //�� ������ ���ϵ�.
		return row;
	}
	public int deleteEmp(int id) {
		int row = session.delete("deleteemp",id);
		return row;
	}
	public List<EmpVO> pagingEmp(int[] param){
		List<EmpVO> list = session.selectList("pagingemp",param);
		return list;
	}

}
