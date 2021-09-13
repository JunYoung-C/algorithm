package chap08;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 5;
		String s2 = "안녕하살법ㅇㅇ";
		System.out.print("패턴 : _");
		System.out.printf(String.format("%%%ds\n", len), s2);
	}

}
