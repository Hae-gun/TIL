package nonspring;

public class TVFactory {

	public TV getTV(String name) {
		if (name.equals("��Ƽ")) {
			return new MultiTV();
		} else if (name.equals("�ƴ�")) {
			return new OtherTV();
		} else {
			return null;
		}
	}

}
