package correctbrace;

import java.util.Stack;

class Solution {
  boolean solution(String s) {
    boolean answer = true;
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } 
        if (stack.peek() != '(') {
          return false;
        }
        stack.pop();
      }
    }
    
    if (!stack.isEmpty()) return false;
    return answer;
  }
}
