package proxypattern;

public class B implements ProxyInter {

	ProxyInter p;
	
	public void setP(ProxyInter p) {
		this.p = p;
	}

	@Override
	public void action() {
		System.out.println("B Ŭ���� action ����");
		p.action();
		System.out.println("B Ŭ���� action ����");
	}

}
