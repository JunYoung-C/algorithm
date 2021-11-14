package exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] ch = new int[n + 1];
    ch[1] = 1;
    ch[2] = 2;
    for (int i = 3; i <= n; i++) {
      ch[i] = ch[i-1] + ch[i-2];
    }
    System.out.println(ch[n]);
  }
}
