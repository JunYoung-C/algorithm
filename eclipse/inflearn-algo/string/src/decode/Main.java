package decode;

import java.util.Scanner;

public class Main {
  public String solution(String str, int num) {
    String answer = "";
    // 내가 짠 코드
    // StringBuffer sb = new StringBuffer();
    // for (int i = 0; i < str.length(); i++) {
    // if (str.charAt(i)=='#') sb.append(1);
    // else sb.append(0);
    // }
    //
    // String tmp = sb.toString();
    // for (int i = 0; i < num; i++) {
    // int n = Integer.parseInt(tmp.substring(i*7, i*7+7), 2);
    // answer += (char)n;
    // }

    for (int i = 0; i < num; i++) {
      String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
      int n = Integer.parseInt(tmp, 2);
      answer += (char)n;
      str = str.substring(7);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int num = stdIn.nextInt();
    String str = stdIn.next();
    System.out.println(T.solution(str, num));
  }
}
