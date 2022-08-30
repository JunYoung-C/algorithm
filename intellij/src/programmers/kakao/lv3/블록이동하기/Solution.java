package programmers.kakao.lv3.블록이동하기;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    boolean[][][] isVisited;

    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int L = 0;
        isVisited = new boolean[8][len][len];
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(0, 0, 1, 0));
        for (int i = 0; i < 8; i++) {
            isVisited[i][0][0] = isVisited[i][0][1] = true;
        }

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Location now = que.poll();
                // System.out.println("[" + now.x1 + ", " + now.y1 + "],[" + now.x2 + ", " + now.y2 + "]");
                if (now.x2 == len - 1 && now.y2 == len - 1) {
                    return L;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int nx1 = now.x1 + dx[dir];
                    int ny1 = now.y1 + dy[dir];
                    int nx2 = now.x2 + dx[dir];
                    int ny2 = now.y2 + dy[dir];

                    if (dir % 2 == 1) { // 대각선 이동
                        if (ny2 == now.y1 || nx2 == now.x1) { // nx2, ny2가 회전
                            if (!isValid(nx2, ny2, len, board) || isVisited[dir][ny2][nx2]) {
                                continue;
                            }

                            if ((!now.isVertical() && board[ny2][now.x2] == 0) ||
                                    (now.isVertical() && board[now.y2][nx2] == 0)) {
                                // ㅡ -> |, | -> ㅡ
                                isVisited[dir][ny2][nx2] = true;
                                que.offer(new Location(now.x1, now.y1, nx2, ny2));
                            }
                        } else if (nx1 == now.x2 || ny1 == now.y2) {
                            if (!isValid(nx1, ny1, len, board) || isVisited[dir][ny1][nx1]) {
                                continue;
                            }

                            if ((!now.isVertical() && board[ny1][now.x1] == 0) ||
                                    (now.isVertical() && board[now.y1][nx1] == 0)) {
                                // ㅡ -> |, | -> ㅡ
                                isVisited[dir][ny1][nx1] = true;
                                que.offer(new Location(nx1, ny1, now.x2, now.y2));
                            }
                        }
                    } else { // 상, 우, 하, 좌
                        if (!isValid(nx1, ny1, len, board) || !isValid(nx2, ny2, len, board)) {
                            continue;
                        }

                        if (isVisited[dir][ny1][nx1] && isVisited[dir][ny2][nx2]) {
                            continue;
                        }

                        isVisited[dir][ny1][nx1] = isVisited[dir][ny2][nx2] = true;
                        que.offer(new Location(nx1, ny1, nx2, ny2));

                    }
                }
            }
            // System.out.println();
            L++;
        }
        return answer;
    }

    private boolean isValid(int x, int y, int len, int[][] board) {
        if (x >= 0 && x < len && y >= 0 && y < len && board[y][x] == 0) {
            return true;
        }
        return false;
    }

}

class Location {
    int x1;
    int y1;
    int x2;
    int y2;

    public Location(int x1, int y1, int x2, int y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }

    public boolean isVertical() { // 수직 판단
        if (this.x1 == this.x2) {
            return true;
        }
        return false;
    }
}
