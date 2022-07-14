package programmers.lv1.자연수뒤집어배열로;

class Solution {
    public int[] solution(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        int len = charArr.length;
        int[] answer = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            answer[len - 1 - i] = charArr[i] - '0';
        }

        return answer;
    }
}
