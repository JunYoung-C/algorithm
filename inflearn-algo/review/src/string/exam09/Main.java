package string.exam09;

import java.util.Scanner;

public class Main {
  public int solution(String str) {
    String answer = "";
    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        answer += c;
      }
    }
    return Integer.parseInt(answer);
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
