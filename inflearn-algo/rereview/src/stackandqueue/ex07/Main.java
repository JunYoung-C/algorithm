package stackandqueue.ex07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public String solution(String order, String plans) {
    String answer = "YES";
    Queue<Character> que = new LinkedList<Character>();
    for (char c : order.toCharArray()) {
      que.offer(c);
    }
    
    int cnt = 0;
    for (char c : plans.toCharArray()) {
      if (order.contains(String.valueOf(c))) {
        char now = que.poll();
        cnt++;
        
        if (c != now) {
          return "NO";
        }
      }
    }
    
    if (cnt != order.length()) {
      return "NO";
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String order = stdIn.next();
    String plans = stdIn.next();
    System.out.println(T.solution(order, plans));
  }
}
