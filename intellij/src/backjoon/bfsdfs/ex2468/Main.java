package backjoon.bfsdfs.ex2468;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    static int maxHeight;
    boolean[][] isVisited;

    public int solution(int n, int[][] board) {
        int answer = 1;

        for (int height = 1; height < maxHeight; height++) {
            isVisited = new boolean[n][n];
            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (!isVisited[y][x] && board[y][x] > height) {
                        dfs(height, board, x, y, n);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private void dfs(int height, int[][] board, int x, int y, int n) {
        isVisited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[ny][nx] && board[ny][nx] > height) {
                dfs(height, board, nx, ny, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        br.close();
        System.out.println(T.solution(n, board));
    }
}
