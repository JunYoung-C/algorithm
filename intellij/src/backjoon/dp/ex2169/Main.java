package backjoon.dp.ex2169;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, 0};
    int[][] dp;
    boolean[][] isVisited;

    public int solution(int width, int height, int[][] board) {
        dp  = new int[height][width];
        isVisited = new boolean[height][width];
        isVisited[0][0] = true;
        for (int i = 0; i < height; i++) {
            Arrays.fill(dp[i], -100_001);
        }

        dp[0][0] = board[0][0];
        dfs(width, height, board, 0, 0);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[height - 1][width -1];
    }

    private void dfs(int width, int height, int[][] board, int x, int y) {
        if (x == width - 1 && y == height - 1) {
            return;
        }
        for (int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                continue;
            }

            if (!isVisited[ny][nx] && dp[ny][nx] < dp[y][x] + board[ny][nx]) {
                isVisited[ny][nx] = true;
                dp[ny][nx] = dp[y][x] + board[ny][nx];
                dfs(width, height, board, nx, ny);
                isVisited[ny][nx] = false;
            }
        }
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
