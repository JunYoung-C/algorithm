package compression;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    int count = 1;
    StringBuffer sb = new StringBuffer();
    sb.append(str.charAt(0));

    for (int i = 1; str.length() > i; i++) {
      if (str.charAt(i) == str.charAt(i-1)) {
        count++;
      } else {
        if (count > 1)
          sb.append(count);
        count = 1;
        sb.append(str.charAt(i));
      }
    }
    if (count > 1)
      sb.append(count);
    answer = sb.toString();
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
