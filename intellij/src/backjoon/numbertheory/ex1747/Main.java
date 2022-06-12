package backjoon.numbertheory.ex1747;

import java.util.Scanner;

public class Main {
    int MAX_NUMBER = 10000000;
    boolean[] isNotPrime = new boolean[MAX_NUMBER + 1];

    public int solution(int n) {
        int answer = 0;
        checkPrime();

        for (int num = n; num <= MAX_NUMBER; num++) {
            if (!isNotPrime[num] && isPalindrome(num)) {
                answer = num;
                break;
            }
        }

        return answer;
    }

    private boolean isPalindrome(int num) {
        StringBuilder sb = new StringBuilder();
        int reverseNum = Integer.parseInt(sb.append(num).reverse().toString());
        if (num == reverseNum) {
            return true;
        }
        return false;
    }

    private void checkPrime() {
        isNotPrime[1] = true;
        for (int num = 2; num <= Math.sqrt(MAX_NUMBER); num++) {
            if (!isNotPrime[num]) {
                for (int i = num * 2; i <= MAX_NUMBER; i += num) {
                    isNotPrime[i] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(T.solution(n));
    }
}
