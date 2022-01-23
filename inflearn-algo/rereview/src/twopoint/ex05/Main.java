package twopoint.ex05;

import java.util.Scanner;

public class Main {

  public int solution(int n) {
    int answer = 0;
    int lt = 1, rt = 1;
    int sum = 0;
    
    for (; rt <= (n + 1) / 2; rt++) {
      sum += rt;
      
      while (sum > n) {
        sum -= lt++;
      }
      
      if (sum == n) {
        answer++;
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