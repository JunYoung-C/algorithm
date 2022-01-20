package string.ex07;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    str = str.toUpperCase();
    StringBuffer sb = new StringBuffer(str);
    if (str.equals(sb.reverse().toString())) {
      return "YES";
    } else {
      return "NO";
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();
    
    System.out.println(T.solution(str));
  }
}
