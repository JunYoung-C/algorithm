package programmers.lv2.onetwofour나라의숫자;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = {4, 1, 2};

        while (n > 0) {
            answer.append(numbers[n % 3]);
            if (n % 3 == 0) {
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
        }

        return answer.reverse().toString();
    }
}
