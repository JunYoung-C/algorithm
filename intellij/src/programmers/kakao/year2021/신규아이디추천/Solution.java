package programmers.kakao.year2021.신규아이디추천;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        answer = firstFilter(answer);
        answer = secondFilter(answer);
        answer = thirdFilter(answer);
        answer = fourthFilter(answer);
        answer = fifthFilter(answer);
        answer = sixthFilter(answer);
        answer = seventhFilter(answer);

        return answer;
    }

    private String seventhFilter(String str) {
        while (str.length() <= 2) {
            str += str.charAt(str.length() - 1);
        }

        return str;
    }

    private String sixthFilter(String str) {
        str = str.substring(0, Math.min(15, str.length()));

        return fourthFilter(str);
    }

    private String fifthFilter(String str) {
        if (str.length() == 0) {
            return "a";
        } else {
            return str;
        }
    }

    private String fourthFilter(String str) {
        if (str.length() == 0) {
            return str;
        }

        if (str.charAt(0) == '.') {
            str = str.substring(1);

            if (str.length() == 0) {
                return str;
            }
        }

        if (str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private String thirdFilter(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || !(c == '.' && stack.peek() == '.')) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private String secondFilter(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || Character.isDigit(c) || c == '-'
                    || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String firstFilter(String str) {
        return str.toLowerCase();
    }
}
