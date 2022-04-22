package string.exam02;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    StringBuffer answer = new StringBuffer();
    for (char c : str.toCharArray() ) {
      if (c >= 'a' && c <= 'z') {
        answer.append((char)(c -32));
      } else if (c >= 'A' && c <= 'Z') {
        answer.append((char)(c + 32));
      }
    }
    return answer.toString();
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
