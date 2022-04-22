package stack.exam04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public int solution(String str) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c >= '0' && c <= '9') {
        stack.push(c - '0');
      } else {
        int rt = stack.pop();
        int lt = stack.pop();
        if (c == '+') {
          stack.push(lt + rt);
        } else if (c == '-') {
          stack.push(lt - rt);
        } else if (c == '*') {
          stack.push(lt * rt);
        } else if (c == '/') {
          stack.push(lt / rt);
        }
      }
    }
    answer = stack.get(0);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
