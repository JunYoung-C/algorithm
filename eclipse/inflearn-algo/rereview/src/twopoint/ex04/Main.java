package twopoint.ex04;

import java.util.Scanner;

public class Main {

  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = 0, rt = 0;
    int sum = 0;
    
    for (; rt < n; rt++) {
      sum += arr[rt];

      while (sum > m) {
        sum -= arr[lt++];
      }
      
      if (sum == m) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, m, arr));
  }
}
