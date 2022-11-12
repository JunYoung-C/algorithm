package backjoon.dp.ex2228;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final int MIN = -10_000_000;
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int[][] dp = createDpArr(n, m);
        int[] sum = createSumArr(n, arr);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[1][i] = Math.max(dp[1][i], sum[i] - sum[j]);
            }
        }

        for (int step = 2; step <= m; step++) {
            for (int i = 3; i <= n; i++) {
                if (dp[step][i - 1] != MIN) {
                    dp[step][i] = Math.max(dp[step][i - 1], dp[step][i - 1] + arr[i]);
                }

                if (dp[step - 1][i - 2] != MIN) {
                    dp[step][i] = Math.max(dp[step][i], dp[step - 1][i - 2] + arr[i]);
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print((dp[i][j] == MIN ? "-" : dp[i][j]) + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    private int[][] createDpArr(int n, int m) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = MIN;
            }
        }
        return dp;
    }

    private int[] createSumArr(int n, int[] arr) {
        int[] sum = new int[n + 1];
        sum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        bw.write(T.solution(n, m, arr)+ "");
        bw.flush();
        bw.close();
    }
}
