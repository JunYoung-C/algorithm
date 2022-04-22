package string.ex03;

import java.util.Scanner;

public class Main {

  public String solution(String[] strArr) {
    String answer = "";
    int n = strArr.length;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      String str = strArr[i];
      int len =  str.length();
      if (len > maxLen) {
        maxLen = len;
        answer = str;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String[] strArr = stdIn.nextLine().split(" ");
    System.out.println(T.solution(strArr));
  }
}
