package ex10162;

import java.util.Scanner;

public class Main {
  public int[] solution(int t) {

    int[] btns = new int[] {300, 60, 10};
    int[] cnts = new int[3];
    for (int i = 0; i < 3; i++) {
      if (t >= btns[i]) {
        cnts[i] = t / btns[i];
        t %= btns[i];
      }
    }

    return cnts;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    if (n % 10 != 0)
      System.out.println(-1);
    else {
      for (int i : T.solution(n)) {
        System.out.print(i + " ");
      }
    }
  }
}
