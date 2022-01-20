package string.ex09;

import java.util.Scanner;

public class Main {

  public int solution(String str) {
    int answer = 0;
    StringBuffer sb = new StringBuffer();
    char[] charArr = str.toCharArray();
    int n = str.length();
    for (int i = 0; i < n; i++) {
      if (charArr[i] >= '0' && charArr[i] <= '9') {
        sb.append(charArr[i]);
      }
    }

    answer = Integer.parseInt(sb.toString());
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();

    System.out.println(T.solution(str));
  }
}
