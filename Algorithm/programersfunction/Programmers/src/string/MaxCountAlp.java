package string;

import java.util.Scanner;

<<<<<<< HEAD
//public class MaxCountAlp {
=======
public class MaxCountAlp {
>>>>>>> 17e96aada5ca3e1af0b58d64d6fa181bffc904d6

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
<<<<<<< HEAD
		// ���� ���ڿ� ��� �빮�ڷ� ����.
=======
>>>>>>> 17e96aada5ca3e1af0b58d64d6fa181bffc904d6
		S = S.toUpperCase();
		int index = 0;
		int maxCount = 0;
		int count = 0;
		char[] set = S.toCharArray();

		int[] alpha = new int['z' - 'a' + 1];

		for (int i = 0; i < set.length; i++) {

			alpha[set[i] - 65]++;

		}
		
		for (int a : alpha) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < alpha.length; i++) {
			maxCount = Math.max(maxCount, alpha[i]);
		}
		for (int i = 0; i < alpha.length; i++) {
			index = maxCount == alpha[i] ? i : index;
			if (maxCount == alpha[i]) {
				count++;
			}
		}

		System.out.println("�ְ� �ݺ� Ƚ�� : " + maxCount);
		System.out.println("�ְ� ��ġ : " + index);
		if (count == 1) {
			System.out.println((char) (index + 65));
		} else {
			System.out.println("?");
		}

	}

}
