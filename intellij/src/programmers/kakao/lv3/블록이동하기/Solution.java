package programmers.kakao.lv3.블록이동하기;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public int solution(int[][] board) {
        int answer = 0;
        final int HORIZONTAL = 0;
        final int VERTICAL = 1;
        int len = board.length;
        boolean[][][] isVisited = new boolean[2][len][len];
        int L = 0;
        isVisited[HORIZONTAL][0][1] = isVisited[HORIZONTAL][0][0] = true;
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(0, 0, 1, 0));

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Location now = que.poll();
                // System.out.println(now.x1 + "," + now.y1 + " " + now.x2 + "," + now.y2);
                if ((now.x2 == len - 1) && (now.y2 == len - 1)) {
                    return L;
                }

                for (int dir = 0; dir < dx.length; dir++) {
                    int nx1 = now.x1 + dx[dir];
                    int ny1 = now.y1 + dy[dir];
                    int nx2 = now.x2 + dx[dir];
                    int ny2 = now.y2 + dy[dir];
                    // System.out.println(nx1 + "," + ny1 + " " + nx2 + "," + ny2);

                    if (dir % 2 == 0) {  // 회전 X
                        if (!isValid(nx1, ny1, board) || !isValid(nx2, ny2, board)) {
                            continue;
                        }

                        Location next = new Location(nx1, ny1, nx2, ny2);

                        if (next.isVertical() &&
                                !(isVisited[VERTICAL][ny1][nx1] && isVisited[VERTICAL][ny2][nx2])) {
                            isVisited[VERTICAL][ny1][nx1] = isVisited[VERTICAL][ny2][nx2] = true;
                            que.offer(next);
                        } else if (!next.isVertical() &&
                                !(isVisited[HORIZONTAL][ny1][nx1] && isVisited[HORIZONTAL][ny2][nx2])) {
                            isVisited[HORIZONTAL][ny1][nx1] = isVisited[HORIZONTAL][ny2][nx2] = true;
                            que.offer(next);
                        }
                    } else { // 회전 O
                        if (now.x1 == nx2 || now.y1 == ny2) {// x2, y2이 이동
                            if (!isValid(nx2, ny2, board)) {
                                continue;
                            }

                            Location next = new Location(now.x1, now.y1, nx2, ny2);

                            if (next.isVertical()) {
                                if (board[ny2][now.x2] == 0 && !(isVisited[VERTICAL][now.y1][now.x1]
                                        && isVisited[VERTICAL][ny2][nx2])) {
                                    isVisited[VERTICAL][now.y1][now.x1] =
                                            isVisited[VERTICAL][ny2][nx2] = true;
                                    que.offer(next);
                                }
                            } else {
                                if (board[now.y2][nx2] == 0 && !(isVisited[HORIZONTAL][now.y1][now.x1]
                                        && isVisited[HORIZONTAL][ny2][nx2])) {
                                    isVisited[HORIZONTAL][now.y1][now.x1] =
                                            isVisited[HORIZONTAL][ny2][nx2] = true;
                                    que.offer(next);
                                }
                            }
                        } else { // x1, y1이 이동
                            if (!isValid(nx1, ny1, board)) {
                                continue;
                            }

                            Location next = new Location(nx1, ny1, now.x2, now.y2);

                            if (next.isVertical()) {
                                if (board[ny1][now.x1] == 0 && !(isVisited[VERTICAL][now.y2][now.x2]
                                        && isVisited[VERTICAL][ny1][nx1])) {
                                    isVisited[VERTICAL][now.y2][now.x2] =
                                            isVisited[VERTICAL][ny1][nx1] = true;
                                    que.offer(next);
                                }
                            } else {
                                if (board[now.y1][nx1] == 0 && !(isVisited[HORIZONTAL][now.y2][now.x2]
                                        && isVisited[HORIZONTAL][ny1][nx1])) {
                                    isVisited[HORIZONTAL][now.y2][now.x2] =
                                            isVisited[HORIZONTAL][ny1][nx1] = true;
                                    que.offer(next);
                                }
                            }
                        }
                    }
                }
            }
            // System.out.println();
            L++;
        }

        return answer;
    }

    boolean isValid(int x, int y, int[][] board) {
        int len = board.length;
        return x >= 0 && x < len && y >= 0 && y < len && board[y][x] == 0;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(T.solution(board));
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

    public boolean isVertical() {
        return this.x1 == this.x2;
    }
}
