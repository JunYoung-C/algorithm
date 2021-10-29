package stack.exam05;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public int solution(String str) {
    int answer = 0;
    Stack<Character> stack = new Stack<>();
    int len = str.length();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == '(') {
        stack.push(str.charAt(i));
      } else {
        stack.pop();
        if (str.charAt(i-1) == '(') {
          answer += stack.size();
        } else {
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
