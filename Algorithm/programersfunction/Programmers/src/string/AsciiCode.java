package string;

import java.util.Scanner;

public class AsciiCode {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// �Է°��� ��Ʈ������ ����.
		String ascii = scan.next();
		// ���� String ���ڿ��� ù��° ��Ҹ� ���� char ���·� ����.
		char Asc = ascii.charAt(0);
		// int casting �� ���� �ƽ�Ű code ���
		System.out.println((int)Asc);
		scan.close();
	}
}