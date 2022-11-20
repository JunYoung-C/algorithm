package backjoon.dp.ex2616;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] peopleCounts, int max) {
        int[] sum = createSumArr(n, peopleCounts);
        int[][] dp = new int[4][n + 1]; // 기관차 개수당 1 ~ i까지의 최댓값

        for (int i = 1; i <= 3; i++) {
            for (int j = max * i; j <= n; j++) {
                dp[i][j] = Math.max(sum[j] - sum[j - max] + dp[i - 1][j - max], dp[i][j - 1]);
            }
        }

        return dp[3][n];
    }

    private int[] createSumArr(int n, int[] peopleCounts) {
        int[] sum = new int[n + 1];
        sum[1] = peopleCounts[0];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + peopleCounts[i - 1];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] peopleCounts = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            peopleCounts[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.parseInt(br.readLine());

        br.close();
        bw.write(T.solution(n, peopleCounts, max) + "");
        bw.flush();
        bw.close();
    }
}
