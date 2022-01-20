package string.ex11;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    StringBuffer answer = new StringBuffer();
    int len = str.length();
    
    int cnt = 1;
    for (int i = 1; i < len; i++) {
      char prev = str.charAt(i - 1);
      char now = str.charAt(i);
      
      if (prev != now) {
        answer.append(prev);
        if (cnt > 1) {
          answer.append(cnt);
        }
        cnt = 1;
      } else {
        cnt++;
      }
    }
    
    answer.append(str.charAt(len - 1));
    if (cnt > 1) {
      answer.append(cnt);
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