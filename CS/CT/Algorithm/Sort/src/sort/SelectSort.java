package sort;

import java.util.Scanner;

public class SelectSort {

	public static void main(String[] args) {
		// �������� ���� �� ������ �������� �˰���.

		Scanner scan = new Scanner(System.in);
		int[] array = { 10, 5, 6, 4, 8, 2, 1, 3, 7, 9 };
		int temp;
		int min;

		for (int i = 0; i < array.length ; i++) {
			min = i;
			for (int j = i ; j < array.length; j++) {

				if (array[min] > array[j]) {
					min = j;

				}
			}

			temp = array[min];
			array[min] = array[i];
			array[i] = temp;

		}
		for (int i : array) {
			System.out.printf("%2d ", i);
		}

	}

}
