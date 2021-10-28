package twopoint.exam05;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int lt = 1;
    int sum = 0;
    for (int rt = 1; rt <= n/2+1; rt++) {
      sum += rt;
      if (sum == n) answer++;
      while (sum >= n && lt <= rt) {
        sum -= lt++;
        if (sum == n) answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}
