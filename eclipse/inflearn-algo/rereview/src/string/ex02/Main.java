package string.ex02;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    StringBuffer answer = new StringBuffer();

    for (char c : str.toCharArray()) {
      if (Character.isLowerCase(c)) {
        answer.append(Character.toUpperCase(c));
      } else {
        answer.append(Character.toLowerCase(c));
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
