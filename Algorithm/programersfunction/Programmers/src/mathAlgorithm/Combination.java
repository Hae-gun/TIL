package mathAlgorithm;

import java.util.Stack;

public class Combination {

	public static void main(String[] args) {
		String[] s = {"a","b","c"};
		
		MyCombination cm = new MyCombination(s);
		cm.doCombination(s.length, 2, 0);
		
	}
	

}

class MyCombination{
	private String[] arr; // ���� �迭.
	private Stack<String> st; // ������ ������ ����.
	
		
	

	public MyCombination(String[] arr) {
		this.arr = arr;				// �迭�� �޾� ��ü�� ����.
		st = new Stack<String>();	// ���ÿ� �޸𸮸� �Ҵ��Ѵ�.
	}
	
	// stack �� ����ϱ� ���� �ż���
	public void showStack() {
		for(int i = 0 ; i < st.size() ; i++) {
			System.out.println(st.get(i)+" ");
		}
		System.out.println(""); // ����
	}
	
	public void doCombination(int n, int r, int index) {
		// n : ��ü ������ ����.
		// r : ���� ������ ����.
		// index : �迭�� �ٷ�� ���� ����.
		if(r==0) // ���̻� ���� ���� ���ٴ� �ǹ��̴�. ������ ��½�Ų��.
		{
			showStack();
			return;
		}else if(n==r) { // nCn : n���� n ���� �̴��ǹ̴� ������ �� �̴´ٴ� �ǹ��̴�.
			for(int i = 0 ; i <n ; i++) {
				st.add(arr[index+i]); // stack�� ä������
			}
			for(int i = 0 ; i<n; i++) {
				st.pop(); // stack �� �����.
			}
		}else {
			// ���� �� ��쿡 �ɸ��� �ʴ°�� ��ȭ�Ĵ�� �����Ѵ�.
			
			// index �� �����ϴ� ���.
			st.add(arr[index]);
			// index�� stack�� �������·� ���� ��ȭ�� ����
			doCombination(n-1, r-1, index+1); 
			
			//index�� �������� �ʴ� ���
			st.pop(); // index ��츦 ���� ���¿���
			doCombination(n-1,r,index+1);
			
			
		}
		
		
		
	}
}
