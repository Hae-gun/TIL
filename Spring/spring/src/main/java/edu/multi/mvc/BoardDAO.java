package edu.multi.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class BoardDAO {

	// BoardTable ��ü �Խù� ��ȸ �޼ҵ�.
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // ����ڰ� ������ Ŭ�������� ������̼� ����. ArrayList�� �ǵ��� ��������.
		try {
			// 1. jdbc driver�ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db ���� �ο��ϰ� db ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql ���� - ����
			PreparedStatement pt = con.prepareStatement("select * from board order by time desc");
			// 4. sql ���� ��� �̿�. ResultSet <- select
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {// select ���ڵ� ���� ������ ����.
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);

			}
			// 5. db ��������
			rs.close();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �ش� �۹�ȣ�� �ش��ϴ� �ż��� ȣ��
	public BoardVO getBoardDetail(int seq) {
		BoardVO vo = null;
		try {
			// 1. jdbc driver�ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db ���� �ο��ϰ� db ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			//2_1. �˻��ϸ� ��ȸ���� 1����.
			PreparedStatement pt0 = con.prepareStatement("update board set viewcount=(viewcount+1) where seq=?");
			// 3. sql ���� - ����
			pt0.setInt(1, seq);
			PreparedStatement pt = con.prepareStatement("select * from board where seq=?");
			
			// 4. sql ���� ��� �̿�. ResultSet <- select
			pt.setInt(1, seq);
			
			 int update = pt0.executeUpdate();//ī��Ʈ�ø���.
			 ResultSet rs = pt.executeQuery();//1�� ���ڵ�(��ġ ���� ������ ����Ŵ)
			
			rs.next();//ù��° ���ڵ� �̵��Ҷ��� �ѹ��� �ؾ���.
			vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contents"));
			vo.setWriter(rs.getString("writer"));
			vo.setTime(rs.getString("time"));
			vo.setViewcount(rs.getInt("viewcount"));
			// 5. db ��������
			rs.close();
			pt.close();
			pt0.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// �ۼ��� 1�� �Խù� ���� .
	public int insertBoard(BoardVO vo) {
		int result = 0;
		try {
			// 1. jdbc driver�ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db ���� �ο��ϰ� db ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql ���� - ����
			String insertsql = "insert into board values((SELECT MAX(SEQ)+1 FROM BOARD),?,?,?, SYSDATE, ?, 0)";
			PreparedStatement pt = con.prepareStatement(insertsql);
			// 4. sql ���� ��� �̿�.
			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			result = pt.executeUpdate();

			// 5. db ��������
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;// ����� 1�̸� �������� insert
	}

	// 1�� �Խù� ��ȸ �Խù� ��ȣ �Է¹޾Ƽ� ����. //���� "��" or ���� "�ڹ�"
	public int deleteBoard(int seq) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db ���� �ο��ϰ� db ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql ���� - ����
			String deletesql = "delete from board where seq = ?";
			PreparedStatement pt = con.prepareStatement(deletesql);
			// 4. sql ���� ��� �̿�.

			pt.setInt(1, seq);
			result = pt.executeUpdate();

			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 1�� �Խù� ����

	// 1�� �Խù� ����

}
