package string.ex10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public int[] solution(String s, char c) {
    int len = s.length();
    int[] answer = new int[len];
    char[] charArr = s.toCharArray();
    Arrays.fill(answer, Integer.MAX_VALUE);
    
    for (int i = 0; i < len; i++) {
      if (charArr[i] == c) {
        answer[i] = 0;
      }
    }
    
    for (int i = 1; i < len; i++) {
      if (answer[i - 1] != Integer.MAX_VALUE) {
        answer[i] = Math.min(answer[i - 1] + 1, answer[i]);
      }
    }
    
    for (int i = len - 2; i >= 0; i--) {
      answer[i] = Math.min(answer[i + 1] + 1, answer[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String s = stdIn.next();
    char c = stdIn.next().charAt(0);
    
    for (int i : T.solution(s, c)) {
      System.out.print(i + " ");
    }
  }
}