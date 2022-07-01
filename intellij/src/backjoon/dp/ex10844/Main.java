package backjoon.dp.ex10844;

import java.io.*;

public class Main {
    public long solution(int n) {
        long answer = 0;
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int row = 2; row <= n; row++) {
            for (int col = 0; col < 10; col++) {
                long sum = 0;
                if (col - 1 >= 0) {
                    sum += dp[row - 1][col - 1];
                }
                if (col + 1 < 10) {
                    sum += dp[row - 1][col + 1];
                }

                dp[row][col] = sum % 1000000000;
            }
        }

        for (int col = 1; col < 10; col++) {
            answer += dp[n][col];
        }

        return answer % 1000000000;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        br.close();
        bw.write(T.solution(n)+ "");
        bw.flush();
        bw.close();
    }
}
