package programmers.kakao.lv2.괄호변환;

import java.util.*;

class Solution {
    public String solution(String p) {
        return makeCorrectString(p);
    }

    private String makeCorrectString(String str) {
        int index = findSeperateIndex(str);
        String prevString = "";
        String nextString = "";

        if (index != -1) {
            prevString = str.substring(0, index);
            nextString = makeCorrectString(str.substring(index));
        } else {
            prevString = str;
        }

        if (isCorrectBrace(prevString)) {
            return prevString + nextString;
        } else {
            StringBuilder sb = new StringBuilder();
            char[] charArr = prevString.toCharArray();
            for (int i = 1; i < charArr.length - 1; i++) {
                if (charArr[i] == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return "(" + nextString + ")" + sb.toString();
        }

    }

    private boolean isCorrectBrace(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int findSeperateIndex(String str) {
        int ltCount = 0;
        int rtCount = 0;
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                ltCount++;
            } else {
                rtCount++;
            }

            if (ltCount == rtCount) {
                index = i + 1;
                break;
            }
        }

        if (index == str.length()) {
            return -1;
        } else {
            return index;
        }
    }
}
