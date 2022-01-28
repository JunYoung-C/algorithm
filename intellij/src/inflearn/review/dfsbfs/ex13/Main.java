package inflearn.review.dfsbfs.ex13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public int solution(int n, int[][] map) {
        int answer = 0;
        boolean[][] isVisited = new boolean[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] == 1 && !isVisited[row][col]) {
                    answer++;
                    bfs(col, row, n, map, isVisited);
                }
            }
        }

        return answer;
    }

    void bfs(int x, int y, int n, int[][] map, boolean[][] isVisited) {
        isVisited[y][x] = true;
        Queue<XY> que = new LinkedList<>();
        que.offer(new XY(x, y));

        while (!que.isEmpty()) {

            XY now = que.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[ny][nx] && map[ny][nx] == 1) {
                    isVisited[ny][nx] = true;
                    que.offer(new XY(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = stdIn.nextInt();
            }
        }

        System.out.println(T.solution(n, map));
    }
}
