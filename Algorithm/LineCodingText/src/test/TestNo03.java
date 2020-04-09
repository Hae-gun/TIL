package test;

import java.util.ArrayList;

public class TestNo03 {

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String road = "111011110011111011111100011111";
		System.out.println(sol.solution(road, 0));
	}

}

class Solution3 {
	public int solution(String road, int n) {
		int answer = -1;

		// 1. 0 �� n�� ü��� �ݺ���.
		char[] set = road.toCharArray();
		int countZero = 0;
		for (char c : set) {
			if (c == '0') {
				countZero++;
			}
		}

		ArrayList<Object> indexZero = new ArrayList();

		for (int i = 0; i < set.length; i++) {
			if (set[i] == '0') {
				indexZero.add(i);
			}
		}

		// 2. 0�� n�� 1�� �ٲ��� ���ӵǴ� 1�� �ִ� ���� ���ϱ�.

		String[] One = road.split("0");
		int[] oneLength = new int[One.length];
		for(int i =0 ; i < One.length ; i++) {
			oneLength[i] = One[i].length();
		}
		
		for (int i = 0; i < oneLength.length; i++) {
			answer = Math.max(answer,oneLength[i]);
		}
		
		return answer;
	}
}
