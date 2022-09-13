package programmers.kakao.lv3.경주로건설;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int len = board.length;
        Queue<Route> que = new LinkedList<>();
        int[][][] distance = new int[4][len][len];
        for (int dir = 0; dir < 4; dir++) {
            for (int i = 0; i < len; i++) {
                Arrays.fill(distance[dir][i], Integer.MAX_VALUE);
            }
        }
        for (int dir = 0; dir < 4; dir++) {
            distance[dir][0][0] = 0;
        }

        que.offer(new Route(0, 0, -1, 0));

        while (!que.isEmpty()) {
            Route now = que.poll();

            if (now.dir != -1 && distance[now.dir][now.y][now.x] < now.cost) {
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= len || ny < 0 || ny >= len || board[ny][nx] == 1) {
                    continue;
                }

                int cost = now.cost + 100;
                if (now.dir != -1 && now.dir != dir) {
                    cost += 500;
                }

                if (distance[dir][ny][nx] > cost) {
                    distance[dir][ny][nx] = cost;
                    que.offer(new Route(nx, ny, dir, cost));
                }
            }
        }

        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, distance[dir][len - 1][len - 1]);
        }

        return answer;
    }
}

class Route{
    int x;
    int y;
    int dir;
    int cost;

    public Route(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
