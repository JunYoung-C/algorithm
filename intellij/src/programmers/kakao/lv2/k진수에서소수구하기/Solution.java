package programmers.kakao.lv2.k진수에서소수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertedNum = Integer.toString(n, k);
        String[] convertedNumArr = convertedNum.split("0");
        for (String s : convertedNumArr) {
            if (s == null || s.equals("") || s.length() == 0) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
