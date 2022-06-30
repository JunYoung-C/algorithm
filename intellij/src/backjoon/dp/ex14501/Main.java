package backjoon.dp.ex14501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[] times, int[] profits, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + times[i]; j <= n; j++) {
                dp[j] = Math.max(dp[i] + profits[i], dp[j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] profits = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(T.solution(times, profits, n)+ "");
        bw.flush();
        bw.close();
    }
}
