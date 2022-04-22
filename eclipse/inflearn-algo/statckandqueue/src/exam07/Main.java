package exam07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public String solution(String need, String random) {
    String answer = "YES";
    Queue<Character> que = new LinkedList<>();
    for (char x : need.toCharArray()) que.offer(x);
    for (char x : random.toCharArray()) {
      if (que.contains(x)) {
        if (x != que.poll()) {
          return "NO";
        }
      }
    }
    if (!que.isEmpty()) {
      return "NO";
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String need = stdIn.next();
    String random = stdIn.next();
    System.out.println(T.solution(need, random));
  }
}
