package string.exam11;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    StringBuffer sb = new StringBuffer();
    int cnt = 1;
    sb.append(str.charAt(0));
    int len = str.length();
    for (int i = 1; i < len; i++) {
      if (str.charAt(i) == str.charAt(i-1)) {
        cnt++;
      } else {
        if (cnt != 1) {
          sb.append(cnt);
        }
        cnt = 1;
        sb.append(str.charAt(i));
      }
    }
    
    if (cnt != 1) {
      sb.append(cnt);
    }
    answer = sb.toString();
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
