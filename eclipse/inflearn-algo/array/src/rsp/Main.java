package rsp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public ArrayList<String> solution(int[] a, int[] b, int n) {
    ArrayList<String> answer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int dif = a[i] - b[i];
      if (dif == 1 || dif == -2) {
        answer.add("A");
      } else if(dif == -1 || dif == 2) {
        answer.add("B");
      } else {
        answer.add("D");
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
    for (String s : T.solution(a, b, n)) {
      System.out.println(s);
    }
  }
}
