package programmers.kakao.lv3.경주로건설;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int[][] cache = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        Queue<Road> que = new LinkedList<>();
        que.offer(new Road(0, 0, -1, 0));
        cache[0][0] = 0;

        while (!que.isEmpty()) {
            Road now = que.poll();

            if (cache[now.y][now.x] < now.cost) {
                continue;
            }

            // System.out.println(now.x + " " + now.y + " " + cache[now.y][now.x]);

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= len || ny < 0 || ny >= len || board[ny][nx] == 1) {
                    continue;
                }

                int cost = 100;
                if (now.dir != -1 && dir != now.dir) {
                    cost += 500;
                }

                if (cache[ny][nx] >= now.cost + cost) {
                    cache[ny][nx] = now.cost + cost;
                    que.offer(new Road(nx, ny, dir, cache[ny][nx]));
                }

            }
        }
        return cache[len - 1][len - 1];
    }
}

class Road {
    int x;
    int y;
    int dir;
    int cost;

    public Road(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir =dir;
        this.cost = cost;
    }
}
