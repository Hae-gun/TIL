package proxypattern;

public class ProxyMain {

	public static void main(String[] args) {
		ProxyInter p = new C();
		B b1 = new B(); // A,C ��ü ���� ���� ���� ���� ��ü.
		b1.setP(p);
		b1.action(); // B + (A or C)
		
		System.out.println("====================================");
		p.action();
		
	}

}
