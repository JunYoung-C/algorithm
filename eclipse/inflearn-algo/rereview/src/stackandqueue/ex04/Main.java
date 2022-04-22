package stackandqueue.ex04;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public int solution(String str) {
    int answer = 0;
    Stack<Integer> stack = new Stack<Integer>();

    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c - '0');
      } else {
        int rt = stack.pop();
        int lt = stack.pop();
        int num = operate(lt, rt, c);
        stack.push(num);
      }
    }

    answer = stack.pop();
    return answer;
  }

  int operate(int lt, int rt, char oper) {
    int ans = 0;
    if (oper == '+') {
      ans = lt + rt;
    } else if (oper == '-') {
      ans = lt - rt;
    } else if (oper == '*') {
      ans = lt * rt;
    } else {
      ans = lt / rt;
    }
    return ans;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
