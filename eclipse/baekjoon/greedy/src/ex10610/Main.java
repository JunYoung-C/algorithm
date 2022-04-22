package ex10610;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";

    if (!str.contains("0"))
      return "-1";
    
    String[] strArr = str.split("");
    Arrays.sort(strArr, Collections.reverseOrder());
    
    int sum = 0;
    for (String s : strArr) {
      int num = Integer.parseInt(s);
      sum += num;
    }
    if (sum % 3 != 0)
      return "-1";

    answer = String.join("", strArr);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
