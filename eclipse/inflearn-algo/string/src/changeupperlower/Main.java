package changeupperlower;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String changedStr = "";
    for (int i = 0; str.length() > i; i++) {
      if (Character.isUpperCase(str.charAt(i))== true) {
        changedStr += Character.toLowerCase(str.charAt(i));
      } else {
        changedStr += Character.toUpperCase(str.charAt(i));
      }
    }
    // 향상된 for문을 사용해도 좋다.
    // 아스키코드를 사용해서 대소문자 판별할 수 있다.
    return changedStr;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }

}
