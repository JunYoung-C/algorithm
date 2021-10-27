package string.exam06;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    StringBuffer sb = new StringBuffer();
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray()) {
      if (map.get(c) == null) {
        sb.append(c);
        map.put(c, 1);
      }
    }
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
