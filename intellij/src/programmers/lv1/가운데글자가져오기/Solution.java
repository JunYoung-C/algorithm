package programmers.lv1.가운데글자가져오기;

class Solution {
    public String solution(String s) {
        int len = s.length();
        String answer = "";
        if (len % 2 == 0) {
            answer += s.charAt(len / 2 - 1);
            answer += s.charAt(len / 2);
        } else {
            answer += s.charAt(len / 2);
        }

        return answer;
    }
}
