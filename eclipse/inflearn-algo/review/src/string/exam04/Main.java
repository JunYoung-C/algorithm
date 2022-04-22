package string.exam04;

import java.util.Scanner;

public class Main {
  public String[] solution(int n, String[] arr) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      StringBuffer sb = new StringBuffer(arr[i]);
      answer[i] = sb.reverse().toString();
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i <n; i++) {
      arr[i] = stdIn.next();
    }
    for (String s : T.solution(n, arr)) {
      System.out.println(s);
    }
  }
}
