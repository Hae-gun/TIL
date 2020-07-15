#include<stdio.h>

int n,ret;

struct Board {
	int map[20][20];

	// �迭 ȸ�� �Լ�.
	void rotate() {
		int temp[20][20];
		// �ش� �迭�� 90�� ȸ��
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				temp[y][x] = map[n - x - 1][y];
			}
		}
		// ȸ���� �迭�� �ٽ� ����.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				map[y][x] = temp[y][x];
			}
		}
	}

	// �ش� �迭���� ���� ū���� �������� �Լ�.
	int get_max() {
		// ����� �ʱ�ȭ.
		int ret = 0;
		// ����Ž��.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				// Ž���� ���� ret�� ���� ũ�� 
				if (ret < map[y][x]) {
					// Ž������ ret�� ����.
					ret = map[y][x];
				}
			}
		}
		return ret;
	}

	// ���ڸ� �÷� �������� ������ 2������.
	void up() {
		int temp[20][20];

		for (int x = 0; x < n; ++x) {
			// flag ���ڸ� ���� ��ģ���� ������ flag�� 1�� ����
			int flag = 0, target = -1;
			for (int y = 0; y < n; ++y) {
				if (map[y][x] == 0) {
					continue;
				}// 
				if (flag == 1 && map[y][x] == temp[target][x]) {
					temp[target][x] *= 2, flag = 0;
				}// temp �迭�� ������ġ�� ���� �����ϰ� flag�� 1�θ���-> �ٲܰ� ����.
				else {
					temp[++target][x] = map[y][x], flag = 1;
				}
			}// ���� for���� ������ target�� ��� �� ���� �ø��� ������ ĭ�� index�� ����Ŵ.
			// �Ʒ��� for���� target index �� �����ڸ��� ĭ�� ��� 0���� �������.
			for (++target; target < n; ++target) {
				temp[target][x] = 0;
			}
		}
		// up �� ������ temp �迭�� BoardŬ������ map�� �����Ŵ.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				map[y][x] = temp[y][x];
			}
		}
		
	}

};


void dfs(Board cur, int count) {
	if (count == 5) {
		int candi = cur.get_max();
		if (ret < candi) {
			ret = candi;
		}
		return;
	}

	for (int dir = 0; dir < 4; ++dir) {
		Board next = cur;
		next.up();
		dfs(next, count + 1);
		cur.rotate();
	}
}


int main() {

	Board board;
	scanf("%d", &n);

	for (int y = 0; y < n; ++y) {
		for (int x = 0; x < n; ++x) {
			scanf("%d", &board.map[y][x]);
		}
	}
	ret = 0;
	dfs(board,0);
	printf("%d\n", ret);

	return 0;
}