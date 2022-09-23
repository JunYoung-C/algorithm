package programmers.kakao.year2020.괄호변환;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (isCorrectString(p)) {
            return p;
        } else {
            return process(p);
        }
    }

    private String process(String s) {
        if (s.length() == 0) {
            return s;
        }

        int separateIndex = getSeparateIndex(s);
        String lt = s.substring(0, separateIndex);
        String rt = s.substring(separateIndex);

        if (isCorrectString(lt)) {
            return lt + process(rt);
        } else {
            return "(" + process(rt) + ")" + handleString(lt);
        }
//        System.out.println(isCorrectString(lt));
//        System.out.print(lt + " " + rt + ".");
    }

    private String handleString(String s) {
        if (s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.substring(1, s.length() - 1).toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private boolean isCorrectString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.pop() != '(') {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private int getSeparateIndex(String s) {
        int ltBraceCount = 0, rtBraceCount = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                ltBraceCount++;
            } else {
                rtBraceCount++;
            }

            if (ltBraceCount == rtBraceCount) {
                index = i + 1;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        String p = "(()())()";
//        String p = ")(";
        String p = "()))((()";
        System.out.println(T.solution(p));
    }
}
