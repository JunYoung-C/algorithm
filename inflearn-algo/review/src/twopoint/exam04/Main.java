package twopoint.exam04;

import java.util.Scanner;

public class Main {
  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = 0;
    int rt = 0;
    int sum = 0;
    while (lt < n && rt < n) {
      if (lt > rt) lt++;
      if (sum == m) {
        answer++;
        sum += arr[rt++] - arr[lt++];
      } else if (sum > m) {
        sum -= arr[lt++];
      } else {
        sum += arr[rt++];
      }
      
    }
    
    while (sum >= m && lt < n) {
      if (sum == m) {
        answer++;
      }
      sum -= arr[lt++];
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
  }
}
