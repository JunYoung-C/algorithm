package programmers.lv1.문자열다루기기본;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if (len != 4 && len != 6) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return answer;
    }
}
