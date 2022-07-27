package programmers.lv2.괄호회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> braceMap = new HashMap<>();
        braceMap.put('(', ')');
        braceMap.put('{', '}');
        braceMap.put('[', ']');
        Queue<Character> que = new LinkedList<>();
        for (char c : s.toCharArray()) {
            que.offer(c);
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;

            for (char c : que) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (braceMap.containsKey(stack.peek()) && braceMap.get(stack.peek()) == c) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        count++;
                    }
                } else {
                    stack.push(c);
                }

            }

            if (!stack.isEmpty()) {
                count = 0;
            }
            stack.clear();
            answer = Math.max(answer, count);
            que.offer(que.poll());
        }

        return answer;
    }
}
