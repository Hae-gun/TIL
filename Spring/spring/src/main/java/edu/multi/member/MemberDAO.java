package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {//mybatis-spring.xml �������� ������� ����.
	@Autowired
	//@Qualifier("")�� ���� � xml�̿����� �����ϴ��ϴ�.
	SqlSession sqlSession;
	
	public MemberVO selectMember(String userid, String password) {
//		sql���� : select * from member where userid=? and password=?
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo = sqlSession.selectOne("getmember", vo);/* �迭 or VO�� ����. */
		return vo;
	}
	public MemberVO checkMember(MemberVO vo) {
		return sqlSession.selectOne("checkmember", vo);
		
	}
	public void insertMember(MemberVO vo) {
		
		sqlSession.insert("insertmember", vo);
		
	}
}
