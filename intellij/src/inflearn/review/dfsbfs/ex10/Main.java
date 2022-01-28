package inflearn.review.dfsbfs.ex10;

import java.util.Scanner;

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int answer = 0;
    boolean[][] isVisited = new boolean[8][8];

    public int solution(int[][] map) {

        isVisited[1][1] = true;
        dfs(1, 1, 7, map);
        return answer;
    }

    void dfs(int x, int y, int n, int[][] map) {
        if (x == n && y == n) {
            answer++;
            return;
        } else {
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 1 && nx <= n && y >= 1 && ny <= n && !isVisited[ny][nx] && map[ny][nx] == 0) {
                    isVisited[ny][nx] = true;
                    dfs(nx, ny, n, map);
                    isVisited[ny][nx] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int[][] map = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                map[i][j] = stdIn.nextInt();
            }
        }

        System.out.println(T.solution(map));
    }
}
