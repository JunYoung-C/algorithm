package programmers.lv1.없는숫자더하기;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int len = numbers.length;
        boolean[] existNumber = new boolean[10];
        for (int i = 0; i < len; i++) {
            existNumber[numbers[i]] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!existNumber[i]) {
                answer += i;
            }
        }
        return answer;
    }
}
