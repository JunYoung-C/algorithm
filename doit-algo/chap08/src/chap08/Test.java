package chap08;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abc안녕abc";
		System.out.println(test.substring(4, 5));
		System.out.println(test.substring(4, 5).length());
		System.out.println(test.substring(4, 5).getBytes());
		System.out.println(test.substring(4, 5).getBytes().length);
	}

}
