package backjoon.dp.ex2208;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int min, int[] gems) {
        int answer = 0;
        int[] sum = createSumArr(n, gems);
        int[] dp = new int[n + 1];

        dp[min] = sum[min] - sum[0];
        for (int i = min + 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + gems[i], sum[i] - sum[i - min]);
        }

        for (int i = min; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return answer;
    }

    private int[] createSumArr(int n, int[] gems) {
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + gems[i];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int[] gems = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            gems[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        bw.write(T.solution(n, min, gems)+ "");
        bw.flush();
        bw.close();
    }
}
