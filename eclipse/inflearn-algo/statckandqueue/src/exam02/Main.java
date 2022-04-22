package exam02;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public String solution(String str) {
    // 내가 짠 코드
//    StringBuffer answer = new StringBuffer();
//    Stack<Character> stack = new Stack<>();
//    for (char c : str.toCharArray()) {
//      if (c == '(') {
//        stack.push(c);
//      } else if (c == ')') {
//        stack.pop();
//      } else {
//        if (stack.isEmpty()) {
//          answer.append(c);
//        }
//      }
//    }
//    
//    return answer.toString();
    
    // 스택에 싹 다 넣는 방식
    String answer = "";
    Stack<Character> stack = new Stack<>();
    for (char x : str.toCharArray()) {
      if (x == ')') {
        while (stack.pop() != '(');
      } else {
        stack.push(x);
      }
    }
    for (int i = 0; i < stack.size(); i++) answer += stack.get(i);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
