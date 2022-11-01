package backjoon.dp.ex1937;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int[][] dp;

    public int solution(int n, int[][] board) {
        initDp(n);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                dfs(r, c, board);
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j], max);
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }
        return max;
    }

    private int dfs(int y, int x, int[][] board) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        int moveCount = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                continue;
            }

            if (board[ny][nx] > board[y][x]) {
                moveCount = Math.max(moveCount, dfs(ny, nx, board) + 1);
            }
        }

        return dp[y][x] = moveCount;
    }

    private void initDp(int n) {
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(n, board)+ "");
        bw.flush();
        bw.close();
    }
}
