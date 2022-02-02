package inflearn.review.dp.ex02;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        answer = dp[n + 1];
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        System.out.println(T.solution(n));
    }
}