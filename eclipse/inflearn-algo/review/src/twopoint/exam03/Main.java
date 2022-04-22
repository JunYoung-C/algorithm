package twopoint.exam03;

import java.util.Scanner;

public class Main {
  public int solution(int n, int k, int[] arr) {
    int answer = 0;
    int lt = 0;
    int rt = 0;
    int sum = 0;
    for (;rt < k; rt++) {
      sum += arr[rt];
    }
    answer = sum;
    
    for (; rt < n; rt++, lt++) {
      sum += arr[rt] - arr[lt];
      answer = Math.max(answer, sum);
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
