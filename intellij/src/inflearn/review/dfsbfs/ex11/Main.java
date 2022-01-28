package inflearn.review.dfsbfs.ex11;

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
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int answer = 0;

    public int solution(int[][] map) {

        answer = bfs(7, map);
        return answer;
    }

    int bfs(int n, int[][] map) {
        Queue<XY> que = new LinkedList<>();
        que.offer(new XY(1, 1));
        boolean[][] isVisited = new boolean[8][8];
        isVisited[1][1] = true;
        int L = 1;

        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                XY now = que.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];
                    if (nx == n && ny == n) {
                        return L ;
                    }
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !isVisited[ny][nx] && map[ny][nx] == 0) {
                        isVisited[ny][nx] = true;
                        que.offer(new XY(nx, ny));
                    }
                }
            }

            L++;
        }
        return -1;
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
