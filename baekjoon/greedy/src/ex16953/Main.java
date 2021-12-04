
package ex16953;

import java.util.Scanner;

public class Main {
  public int solution(int a, int b) {
    int cnt = 1;

    while (b > a) {
      if (b % 2 == 0) {
        b = b/2;
      } else if (b % 10 == 1) {
        b = b / 10;
      } else {
        break;
      }
      cnt++;
    }

    if (b == a) return cnt;
    else return -1;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int a = stdIn.nextInt();
    int b = stdIn.nextInt();
    System.out.println(T.solution(a, b));
  }
}

