package hash.exam06;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public String solution(String str) {
    String answer = "YES";
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return "NO";
        }
        stack.pop();
      }
    }
    
    if (!stack.isEmpty()) {
      answer = "NO";
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
