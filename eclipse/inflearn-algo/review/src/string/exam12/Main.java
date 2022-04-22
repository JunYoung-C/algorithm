package string.exam12;

import java.util.Scanner;

public class Main {
  public String solution(int n, String str) {
    String answer = "";
    for (int i = 0; i < n; i++) {
      String strCode = str.substring(0, 7);
      str = str.substring(7);
      String binCode = "";
      for (char c: strCode.toCharArray()) {
        if (c == '#') {
          binCode+=1;
        } else {
          binCode += 0;
        }
      }
      answer += (char)Integer.parseInt(binCode, 2);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    String str = stdIn.next();
    System.out.println(T.solution(n, str));
  }
}
