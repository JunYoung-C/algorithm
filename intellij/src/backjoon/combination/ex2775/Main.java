package backjoon.combination.ex2775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for (int number = 1; number < 15; number++) {
            dp[0][number] = number;
        }

        for (int floor = 0; floor < 15; floor++) {
            dp[floor][1] = 1;
        }

        for (int floor = 1; floor < 15; floor++) {
            for (int number = 2; number < 15; number++) {
                dp[floor][number] = dp[floor - 1][number] + dp[floor][number - 1];
            }
        }

        while (testCount-- > 0) {
            int floor = Integer.parseInt(br.readLine());
            int number = Integer.parseInt(br.readLine());
            bw.write(dp[floor][number]+ "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
