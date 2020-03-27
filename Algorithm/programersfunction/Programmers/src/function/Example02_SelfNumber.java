package function;

public class Example02_SelfNumber {

	public static void main(String[] args) {

		int result = PlusNumber(9999);

		// PlusNumber �� ���� ����� ���°��� �������ڰ� �ƴ�.
		int checkNum[] = new int[10001];

		// ���� �迭�� ���� PlusNumber ����� ������ �� �ش� ���� �ش��ϴ� �ε����� ���� 1�� ����.
		// ���ڹ迭�� �˻��Ͽ� �迭�� ���� 0�� index�� ���ڴ� ���� ���ڸ� �ǹ���.

		// for���� ���� ���� ���ڸ� ������Ű�� �ش� ���� PlusNumber�� ��� �����Ű��
		// ����� 10000���� ������ �϶����� ������ ����
		for (int i = 1; i <= 10000; i++) {
			int startNum = i;
			do {
				if (PlusNumber(startNum) <= 10000)
					checkNum[PlusNumber(startNum)]++;
				startNum = PlusNumber(startNum);
			} while (startNum <= 10000);
		}

		for (int i = 1; i < checkNum.length; i++) {
			if (checkNum[i] == 0) {
				System.out.println(i);
			}
		}

	}

	public static int PlusNumber(int Number) {
		int result = Number;
		// �ڽŰ� �� �ڸ����� ���ϱ�.
		while (Number != 0) {
			result += (Number % 10);
			Number /= 10;
		}
		return result;
	}

	// 10000���� �۰ų� ���� �������� ã��.

	// ���� ���� : 1~10000 ���� ���� �ڽŰ� �� �ڸ����ڸ� ���Ͽ� ���� ���ڰ� �� �ϳ��� ���ڷθ� ������ ��.

	/*
	 * ��) ���ۼ� 1 -> 1 + 1 = 2 2 + 2 = 4 4 + 4 = 8 8 + 8 = 16 16 + 1 + 6 = 23 ....
	 * 
	 * 1 �� 2 �� ������. 2 �� 4 �� ������. ...
	 * 
	 * ���ڰ� ���� �� = ��������. ��) 3�� �����ڰ� ����. 3 + 3 = 6 3�� 6�� ������. 6 + 6 = 12
	 * 
	 */

	// ���� �ڱ� �ڽŰ� �� �ڸ����� ���ϴ� ���� ����.

}
