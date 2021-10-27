package string.exam03;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    int max = Integer.MIN_VALUE;
    for (String s : str.split(" ")) {
      if (max < s.length()) {
        max = s.length();
        answer = s;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.nextLine();
    System.out.println(T.solution(str));
  }
}
