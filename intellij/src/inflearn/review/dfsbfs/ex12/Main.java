package inflearn.review.dfsbfs.ex12;

import java.util.ArrayList;
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
    static ArrayList<XY> tomatoes = new ArrayList<>();


    public int solution(int width, int height, int[][] map) {

        answer = bfs(width, height, map);
        return answer;
    }

    int bfs(int width, int height, int[][] map) {
        Queue<XY> que = new LinkedList<>();
        for (XY xy : tomatoes) {
            que.offer(xy);
        }
        int L = -1;

        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                XY now = que.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        que.offer(new XY(nx, ny));
                    }
                }
            }

            L++;
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (map[row][col] == 0) {
                    return -1;
                }
            }
        }
        return L;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int width = stdIn.nextInt();
        int height = stdIn.nextInt();

        int[][] map = new int[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                map[r][c] = stdIn.nextInt();
                if (map[r][c] == 1) {
                    tomatoes.add(new XY(c, r));
                }
            }
        }

        System.out.println(T.solution(width, height, map));
    }
}
