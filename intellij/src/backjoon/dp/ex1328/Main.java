package backjoon.dp.ex1328;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public long solution(int n, int l, int r) {
        int div = 1000000007;
        long[][][] dp = new long[101][101][101];

        dp[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2)) % div;
                }
            }
        }

        return dp[n][l][r];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(T.solution(n, l, r)+ "");
        bw.flush();
        bw.close();
    }
}
