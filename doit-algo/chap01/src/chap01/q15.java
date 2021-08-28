package chap01;

import java.util.Scanner;

public class q15 {

	static void triangleRU(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(' ');
			}
			for(int j = 0; j < n-i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			System.out.println("몇단?: ");
			n = stdIn.nextInt();
		} while(n <= 0);
		
		triangleRU(n);
		
		
	}

}
// '*****' ' '0, '*'5 ' ' i, '*' n-i
// ' ****' ' '1, '*'4
// '  ***' ' '2, '*'3
// '   **' ' '3, '*'2
// '    *' ' '4, '*'1
