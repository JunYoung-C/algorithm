package programmers.lv2.숫자블록;

class Solution {
    public long[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        long[] answer = new long[len];

        for (int i = 0; i < len; i++) {
            answer[i] = getMaxDivider(i + begin);
        }
        return answer;
    }

    private long getMaxDivider(long number) { // 본인을 제외한 최대의 약수 반환
        if (number == 1) {
            return 0;
        }

        for (long i = 2; i <= (long) Math.sqrt(number); i++) {
            if (number % i == 0 && number / i <= 10000000) {
                return number / i;
            }
        }

        return 1;
    }
}
