package removeduplicate;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    String answer = "";
    // 내가 짠 코드
//    StringBuffer sb = new StringBuffer();
//    for (char c: str.toCharArray()) {
//      if (sb.indexOf(Character.toString(c)) == -1) {
//        sb.append(c);
//      }
//    }
//    answer = sb.toString();
    
    for (int i = 0; i < str.length(); i++) {
      if (str.indexOf(str.charAt(i)) == i) {
        answer += str.charAt(i);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
