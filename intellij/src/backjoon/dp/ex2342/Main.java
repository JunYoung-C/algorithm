package backjoon.dp.ex2342;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int answer = Integer.MAX_VALUE;
        int[][][] dp = new int[100001][5][5];
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                for (int i = 0; i < 100001; i++) {
                    dp[i][l][r] = 500000;
                }
            }
        }
        dp[0][0][0] = 0;
        int[][] move = { // i -> j로 가는 데에 소모되는 힘
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};

        int k = 1;
        while (true) {
            int location = stdIn.nextInt();
            if (location == 0) {
                break;
            }

            for (int l = 0; l < 5; l++) {
                if (l == location) {
                    continue;
                }

                for (int r = 0; r < 5; r++) {
                    dp[k][l][location] = Math.min(dp[k - 1][l][r] + move[r][location], dp[k][l][location]);
                }
            }

            for (int r = 0; r < 5; r++) {
                if (r == location) {
                    continue;
                }
                for (int l = 0; l < 5; l++) {
                    dp[k][location][r] = Math.min(dp[k - 1][l][r] + move[l][location], dp[k][location][r]);
                }
            }

            k++;
        }

        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[k - 1][l][r]);
            }
        }

        System.out.println(answer);
    }
}
