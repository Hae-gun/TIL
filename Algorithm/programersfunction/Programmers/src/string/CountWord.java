package string;

import java.util.Scanner;

public class CountWord {

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		String input = scan.nextLine();
//		
//		
//		
//		//String input = " abc def0 ";
//		char[] temp = input.toCharArray();
//		
//		if(temp[0]==' ') {
//			temp[0]='x';
//		}
//		if(temp[temp.length-1]==' ') {
//			temp[temp.length-1]='x';
//		}
//		StringBuffer refactor = new StringBuffer();
//		
//		refactor.append(temp);
//		
//		
//		String[] word = refactor.toString().split(" ");
//		System.out.println(word.length);
// 		�� �ڵ��� ������ 
//		�ƹ��͵� �Է����� �ʾ��� ���� 1�� ��µ�
//		ex) " " �� �Է����� ���� 1�� ����� ��.
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().trim();
		// ���� ������ trim �� �̿��Ͽ� ���� ���� �ٷ� ����.
		if (input.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(input.split(" ").length);
		}

	}

}
