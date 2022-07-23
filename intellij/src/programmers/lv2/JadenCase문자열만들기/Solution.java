package programmers.lv2.JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] charArr = s.toCharArray();
        char prevChar = ' ';
        for (char c : charArr) {
            if (prevChar == ' ' && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                answer.append(Character.toUpperCase(c));
            } else {
                if (c >= 'A' && c <= 'Z') {
                    answer.append(Character.toLowerCase(c));
                } else {
                    answer.append(c);
                }
            }
            prevChar = c;
        }

        return answer.toString();
    }
}
