package kakao;

public class Module {
	public static void main(String[] args) {
		
		
		String s = "[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]";
		s.replaceAll("[", "{");
		s.replaceAll("]", "}");
		System.out.println(s);
	}
}