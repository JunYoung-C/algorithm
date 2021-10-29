package test;

import java.util.Stack;

public class Test {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    if (!stack.isEmpty() && stack.peek() == 0) {
      System.out.print(1);
    }
  }
}
