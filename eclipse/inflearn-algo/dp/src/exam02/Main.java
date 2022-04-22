package exam02;

import java.util.Scanner;

public class Main {
  static int[] ch;
  public int solution(int n) {
    ch = new int[n + 2];
    ch[1] = 1;
    ch[2] = 2;
    for (int i = 3; i <= n+1; i++) {
      ch[i] = ch[i-1] + ch[i-2];
    }
    return ch[n+1];
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();

    System.out.println(T.solution(n));
  }
}
