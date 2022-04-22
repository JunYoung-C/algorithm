package chap08;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] skip = new int[Character.MAX_VALUE + 1];
		int i = 0;
		skip["junyoung".charAt(0)] = 1;
		System.out.println("junyoung".charAt(0));
		System.out.println(skip['j']);
	}

}
