package programmers.lv1.약수의개수와덧셈;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int number = left; number <= right; number++) {
            if (getDivisorCount(number) % 2 == 0) {
                answer += number;
            } else {
                answer -= number;
            }
        }

        return answer;
    }

    private int getDivisorCount(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count;
    }
}
