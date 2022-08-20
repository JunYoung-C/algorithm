package programmers.lv3.oneonezero옮기기;

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (char c : s[i].toCharArray()) {
                if (c == '1') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty() && stack.peek() == '1') {
                        stack.pop();
                        if (!stack.isEmpty() && stack.peek() == '1') {
                            stack.pop();
                            count++;
                        } else {
                            stack.push('1');
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '0') {
                sb.append(stack.pop());
            }

            for (int j = 0; j < count; j++) {
                sb.append("011");
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            answer[i] = sb.reverse().toString();
        }
        return answer;
    }
}