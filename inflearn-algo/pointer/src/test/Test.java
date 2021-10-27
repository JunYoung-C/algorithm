package test;

import java.util.Scanner;

public class Test {
  public int solution(int[] numbers) {
    int answer = -1;
    return answer;
  }

  public static void main(String[] args) {
    Test T = new Test();
    Scanner stdIn = new Scanner(System.in);
    int sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum += i;
    }
    System.out.print(sum);
  }
}
