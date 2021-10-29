package recurtreegraph.exam01;

import java.util.Scanner;

public class Main {
  static int n;
  public void solution(int num) {
    System.out.print(num + " ");
    if (num == n) {
      return;
    } 

    solution(num+1);
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    T.solution(1);
  }
}
