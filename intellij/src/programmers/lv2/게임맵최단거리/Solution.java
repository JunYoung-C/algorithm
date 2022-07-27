package programmers.lv2.게임맵최단거리;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        int width = maps[0].length;
        int height = maps.length;
        boolean[][] isVisited = new boolean[height][width];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0));
        isVisited[0][0] = true;
        int count = 1;
        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                Point now = que.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];

                    if (ny == height - 1 && nx == width - 1) {
                        return count + 1;
                    }

                    if (nx < 0 || nx >= width || ny < 0 || ny >= height || maps[ny][nx] == 0 || isVisited[ny][nx]) {
                        continue;
                    }

                    que.offer(new Point(nx, ny));
                    isVisited[ny][nx] = true;
                }
            }

            count++;
        }

        return -1;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
