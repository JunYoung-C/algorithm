package stack.exam07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public String solution(String needs, String plans) {
    String answer = "NO";
    Queue<Character> needQ = new LinkedList<>();
    Queue<Character> planQ = new LinkedList<>();
    for (char c : needs.toCharArray()) {
      needQ.offer(c);
    }
    for (char plan : plans.toCharArray()) {
      if (needQ.contains(plan)) {
        planQ.offer(plan);
      }
    }
    if (needQ.equals(planQ)) {
      answer = "YES";
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String needs = stdIn.next();
    String plans = stdIn.next();
    System.out.println(T.solution(needs, plans));
  }
}
