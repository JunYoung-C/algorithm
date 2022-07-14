package programmers.lv1.두정수사이의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        // a, a + (n - 1)d -> an + n(n - 1)d / 2
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        long n = max - min + 1;

        answer = min * n + n * (n - 1) / 2;
        return answer;
    }
}
