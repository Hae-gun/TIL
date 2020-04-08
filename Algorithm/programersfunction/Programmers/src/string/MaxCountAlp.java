package string;

import java.util.Scanner;

public class MaxCountAlp {
	// ���� 1157�� ����
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
		// ���� ���ڿ� ��� �빮�ڷ� ����.
		S = S.toUpperCase();
		int index = 0;
		int maxCount = 0;
		int count = 0;
		// �� ���ڿ��� Ȯ���ϱ� ���� char�迭�� ����.
		char[] set = S.toCharArray();

		// �� ���ڿ��� ���� ���ĺ� ���� �˱����� �迭.
		// index : ���ĺ�
		// value : ���� Ƚ��
		// 0 : A ~ 25 : Z
		int[] alpha = new int['z' - 'a' + 1];

		// ���Ĺ� ��ġ�� ã�� 1�� ����.
		for (int i = 0; i < set.length; i++) {

			alpha[set[i] - 65]++;

		}
		
		for (int a : alpha) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		// ���帹�� ���� ���ĺ� ã��.
		for (int i = 0; i < alpha.length; i++) {
			maxCount = Math.max(maxCount, alpha[i]);
		}
		// Max ���� ã�� index�� ����.
		for (int i = 0; i < alpha.length; i++) {
			index = maxCount == alpha[i] ? i : index;
			// maxCount ���� ������ ���� ������� count++
			// count �� 1�̸� �ߺ��Ȱ� ����.
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
