package backjoon.dp.ex2169;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int width, int height, int[][] board) {
        final int RIGHT = 0;
        final int LEFT = 1;
        int[][] dp  = new int[height][width];
        int[][] rowDp = new int[2][width]; // 우, 좌

        dp[0][0] = board[0][0];
        for (int i = 1; i < width; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int row = 1; row < height; row++) {
            rowDp[RIGHT][0] = dp[row - 1][0] + board[row][0];

            for (int col = 1; col < width; col++) {
                rowDp[RIGHT][col] = Math.max(rowDp[RIGHT][col - 1], dp[row - 1][col]) + board[row][col];
            }

            rowDp[LEFT][width - 1] = dp[row - 1][width - 1] + board[row][width - 1];

            for (int col = width - 2; col >= 0; col--) {
                rowDp[LEFT][col] = Math.max(rowDp[LEFT][col + 1], dp[row - 1][col]) + board[row][col];
            }

            for (int col = 0; col < width; col++) {
                dp[row][col] = Math.max(rowDp[LEFT][col], rowDp[RIGHT][col]);
//                System.out.print(rowDp[LEFT][col] + "," + rowDp[RIGHT][col] + " ");
            }
//            System.out.println();
        }

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[height - 1][width -1];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] board = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(width, height, board) + "");
        bw.flush();
        bw.close();
    }
}
