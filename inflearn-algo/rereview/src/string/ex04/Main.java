package string.ex04;

import java.util.Scanner;

public class Main {

  public String[] solution(int n, String[] strArr) {
    String[] answer = new String[n];
    StringBuffer sb;
    
    for (int i = 0; i < n; i++) {
      sb = new StringBuffer(strArr[i]);
      answer[i] = sb.reverse().toString();
    }
    
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    String[] strArr = new String[n];
    for (int i = 0; i < n; i++) {
      strArr[i] = stdIn.next();
    }
    
    for (String s : T.solution(n, strArr)) {
      System.out.println(s);
    }
  }
}
