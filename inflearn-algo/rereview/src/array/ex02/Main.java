package array.ex02;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[] students) {
    int answer = 1;
    int max = students[0];
    for (int i = 1; i < n; i++) {
      if (max < students[i]) {
        max = students[i];
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    
    int[] students = new int[n];
    for (int i = 0; i < n; i++) {
      students[i] = stdIn.nextInt();
    }
    
    System.out.println(T.solution(n, students));
  }
}
