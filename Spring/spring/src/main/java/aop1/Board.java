package aop1;

import java.util.ArrayList;

public class Board {
	public Integer inserBoard(int seq) {
		System.out.println(seq + " ��° �Խù��� ����մϴ�.");
		return seq;
	}

	public ArrayList<String> getList() {
		System.out.println("�Խù� ����Ʈ�� ����մϴ�.");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1:1���Խù�:�������������Դϴ�.");
		list.add("2:2���Խù�:�ȵ���̵�������Դϴ�.");
		list.add("3:3���Խù�:�ϵӼ������Դϴ�.");
		return list;
	}
}
