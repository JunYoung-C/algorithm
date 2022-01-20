package string.ex06;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    StringBuffer sb = new StringBuffer();
    boolean[] isVisited = new boolean['z' - 'a' + 1];
    
    for (char c : str.toCharArray()) {
      if (!isVisited[c - 'a']) {
        isVisited[c - 'a'] = true;
        sb.append(c);
      }
    }
    
    return sb.toString();
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();
    
    System.out.println(T.solution(str));
  }
}
