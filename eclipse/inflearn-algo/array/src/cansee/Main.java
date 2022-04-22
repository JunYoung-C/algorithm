package cansee;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[] nums) {
    int answer = 1;
    int p = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[p]) {
        p = i;
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, nums));
  }
}
