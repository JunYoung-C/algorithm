package array.exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public ArrayList<Character> solution(int n, int[] a, int[] b) {
    ArrayList<Character> answer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int dif = a[i] - b[i];
      if (dif == 0) {
        answer.add('D');
      } else if (dif == 1 || dif == -2) {
        answer.add('A');
      }  else {
        answer.add('B');
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = stdIn.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = stdIn.nextInt();
    }
    for (char c : T.solution(n, a, b)) {
      System.out.println(c);
    }
  }
}
