package stackandqueue.ex02;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public String solution(String str) {
    Stack<Character> stack = new Stack<Character>();
    
    for (char c : str.toCharArray()) {
      if (c == ')') {
        while (stack.pop() != '(') {
        }
      } else {
        stack.push(c);
      }
    }
    
    StringBuffer sb = new StringBuffer();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();
    
    System.out.println(T.solution(str));
  }
}
