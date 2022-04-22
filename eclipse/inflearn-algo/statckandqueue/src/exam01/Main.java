package exam01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public String solution(String str) {
    String answer = "YES";
    // 내가 짠 코드
//    int lt = 0, rt = 0;
//    for (char c : str.toCharArray()) {
//      if (c == '(') {
//        lt++;
//      } else {
//        rt++;
//      }
//      if (rt > lt) return "NO";
//    }
//    
//    if (rt != lt) return "NO";
    
    // 스택 이용
    Stack<Character> stack = new Stack<>();
    for (char x : str.toCharArray()) {
      if (x == '(') stack.push(x);
      else {
        if (stack.isEmpty())return "NO";
        stack.pop();
      }
    }
    if (!stack.isEmpty()) return "NO";
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
