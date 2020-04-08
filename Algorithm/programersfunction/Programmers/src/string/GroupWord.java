package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GroupWord {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// �׷�ܾ� : ������ġ�� ���ڰ� �� ���ڿ� ���� ������ �ڿ� ���ڿ� ������� �ش� �ܾ��

		int tcase = Integer.valueOf(br.readLine());
		String input;
		int result = 0;

		for (int i = 0; i < tcase; i++) {
			input = br.readLine().trim();
			if (checkGroup(input)) {
				result++;
			}

		}
		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();

	}

	public static boolean checkGroup(String input) {
		boolean[] alphabet = new boolean[26]; // �� ��ȣ�� ���ĺ��� �ǹ�. �ش� ĭ�� true�� ��� : �ش繮�ڰ� �ٽ� ���°��.

		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (alphabet[temp - 'a']) {
				return false;
			} else { // �ش� �ܾ ��� ���ӵǸ� �� �ش� �ܾ��� alphabet �迭���� false�̴�. �׷��ٰ� �ڿ� �ٸ��ܾ ��Ÿ���� true�� �����.
						// ���� �ش� �ܾ �ٽ� ��Ÿ���� �Ǹ� �� �ܾ�� �׷�ܾ �ƴ�. ���� ���� if �� ������ �ɷ� false �� ����.
				if (i < input.length() - 1 && temp != input.charAt(i + 1)) {
					alphabet[temp - 'a'] = true;
				}
			}

		}

		return true;
	}

}
