package stackandqueue.ex05;

import java.util.Scanner;

public class Main {

  public int solution(String str) {
    int answer = 0;
    int cnt = 1;
    int len = str.length();

    for (int i = 1; i < len; i++) {
      char now = str.charAt(i);
      char prev = str.charAt(i - 1);

      if (now == '(') {
        cnt++;
      } else { // now == ')'
        if (prev == '(') { // 레이저
          cnt -= 1;
          answer += cnt;
        } else { // 쇠막대기 끝 도달
          cnt--;
          answer += 1;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();

    System.out.println(T.solution(str));
  }
}
