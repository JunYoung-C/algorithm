package stack.exam02;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public String solution(String str) {
    String answer = "";
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == ')') {
        while (stack.pop() != '(') {
        }
      } else {
        stack.push(c);
      }
    }
    
    for (char c : stack) {
      answer += c;
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
