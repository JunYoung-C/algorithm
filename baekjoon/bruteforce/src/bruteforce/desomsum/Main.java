package bruteforce.desomsum;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; i++) {
      if (d(i) == n) {
        return i;
      }
    }
    return answer;
  }

  int d(int num) {
    int tmp = num;
    while (tmp > 0) {
      num += tmp % 10;
      tmp /= 10;
    }
    return num;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}

