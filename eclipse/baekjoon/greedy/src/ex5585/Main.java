package ex5585;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int[] money = new int[] {500, 100, 50, 10, 5, 1};
    for (int m : money) {
      if (n >= m) {
        answer += n / m;
        n = n % m;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(1000 - n));
  }
}

