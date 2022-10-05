package backjoon.dp.ex11048;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int width, int height, int[][] board) {
        int[][] dp = new int[height + 1][width + 1];
        dp[0][0] = board[0][0];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                dp[r + 1][c] = Math.max(dp[r][c] + board[r + 1][c], dp[r + 1][c]);
                dp[r][c + 1] = Math.max(dp[r][c] + board[r][c + 1], dp[r][c + 1]);
                dp[r + 1][c + 1] = Math.max(dp[r][c] + board[r + 1][c + 1], dp[r + 1][c + 1]);
            }
        }

        return dp[height - 1][width - 1];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] board = new int[height + 1][width + 1];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(width, height, board)+ "");
        bw.flush();
        bw.close();
    }
}
