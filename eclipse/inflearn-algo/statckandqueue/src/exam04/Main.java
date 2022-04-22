package exam04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public int solution(String str) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    int sum;
    for(char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c-'0');

      } else {
        int second = stack.pop();
        int first = stack.pop();
        switch (c) {
          case '+' : {
            stack.push(first + second);
            break;
          } case '-' : {
            stack.push(first - second);
            break;
          } case '*' : {
            stack.push(first * second);
            break;
          } case '/' : {
            stack.push(first / second);
            break;
          }
        }
      }

    }
    answer = stack.pop();
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
