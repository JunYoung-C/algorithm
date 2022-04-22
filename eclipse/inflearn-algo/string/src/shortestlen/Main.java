package shortestlen;

import java.util.Scanner;

public class Main {
  // 내가 짠 코드
  // public void solution(String str, char c) {
  // for (int i = 0; i < str.length(); i++) {
  // StringBuffer sb = new StringBuffer(str.substring(0, i + 1));
  // String first = sb.reverse().toString();
  // String last = str.substring(i, str.length());
  //
  // int firstIndex = first.indexOf(c);
  // if (firstIndex == -1)
  // firstIndex = Integer.MAX_VALUE;
  // int lastIndex = last.indexOf(c);
  // if (lastIndex == -1)
  // lastIndex = Integer.MAX_VALUE;
  //
  // if (firstIndex <= lastIndex)
  // System.out.print(firstIndex + " ");
  // else
  // System.out.print(lastIndex + " ");
  // }
  // }
  public int[] solution(String s, char t) {
    int[] answer = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
        answer[i] = p;
      } else {
        p++;
        answer[i] = p;
      }
    }
    
    p = 1000;
    for (int i = s.length()-1; i>=0; i--) {
      if (s.charAt(i) == t) p = 0;
      else {
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    char c = stdIn.next().charAt(0);

    // T.solution(str, c);
    for (int x : T.solution(str, c)) {
      System.out.print(x + " ");
    }
  }
}
