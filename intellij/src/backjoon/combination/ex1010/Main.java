package backjoon.combination.ex1010;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCount = Integer.parseInt(st.nextToken());
        int[][] dp = new int[31][31];
        for (int i = 0; i <= 30; i++) {
            dp[i][1] = i;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = 2; j <= 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        while (testCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            bw.write(dp[n][r]+ "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
