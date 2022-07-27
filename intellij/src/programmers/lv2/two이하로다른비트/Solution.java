package programmers.lv2.two이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        long number;
        for (int i = 0; i < len; i++) {
            number = numbers[i] + 1;
            long addNumber = 1;
            while (true) {
                if (Long.bitCount(number ^ numbers[i]) <= 2) {
                    break;
                }

                number |= addNumber;
                addNumber *= 2;
            }

            answer[i] = number;
        }

        return answer;
    }
}
