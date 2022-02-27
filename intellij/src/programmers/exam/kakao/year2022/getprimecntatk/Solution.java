package programmers.exam.kakao.year2022.getprimecntatk;

import java.util.Scanner;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] numStrArr = getNumber(k, n).split("0");

        for (String numStr : numStrArr) {
            if (!numStr.isBlank() && isPrime(Long.parseLong(numStr))) {
                answer++;
            }
        }

        return answer;
    }

    // k진수로 변환한 num을 String으로 반환
    String getNumber(int k, long num) {
        StringBuilder sb = new StringBuilder();
        long n = num;
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 437674;
        int k = 3;

//        int n = 110011;
//        int k = 10;

//        int n = 100000000;
//        int k = 10;
        System.out.println(T.solution(n, k));
    }
}
