package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 1. jdbc driver�ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db ���� �ο��ϰ� db ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql ���� - ����
			PreparedStatement pt = con.prepareStatement("select * from board");
			// 4. sql ���� ��� �̿�. ResultSet <- select
			ResultSet rs =  pt.executeQuery();
			while(rs.next()) {//select ���ڵ� ���� ������ ����.
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
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	

}
