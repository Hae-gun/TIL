package nonspring;

public class Main {

	public static void main(String[] args) {
		// ��ü ����� �ڵ� ���� �Ұ��� = ���յ��� ����. coupling ����.(�����ڵ� �����ؾ���)
		// tv���� ���� ��ü�� MultiTV, OtherTV 2���ϳ�.
		// dependency:���� ��ü ����.-->����
		
		TVFactory factory = new TVFactory();

		TV tv = factory.getTV(args[0]); // ��ӹ��� �������̽��� ����ȯ ����.
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}

}
