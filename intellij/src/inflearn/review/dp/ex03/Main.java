package inflearn.review.dp.ex03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        answer = Arrays.stream(dp).max().getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
