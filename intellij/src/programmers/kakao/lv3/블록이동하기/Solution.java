package programmers.kakao.lv3.블록이동하기;

import java.util.*;

class Solution {
    final int VERTICAL_STATUS = 1;
    final int HORIZONTAL_STATUS = 0;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int len;

    public int solution(int[][] board) {
        int answer = 0;
        len = board.length;
        boolean[][][] isVisited = new boolean[2][len][len];
        Queue<Robot> que = new LinkedList<>();

        isVisited[HORIZONTAL_STATUS][0][0] = true;
        isVisited[HORIZONTAL_STATUS][0][1] = true;
        que.offer(new Robot(new Point(0, 0), new Point(1, 0)));

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Robot robot = que.poll();
                int x1 = robot.p1.x, y1 = robot.p1.y;
                int x2 = robot.p2.x, y2 = robot.p2.y;

                // System.out.println(x1 + "," + y1 + " " + x2 + "," + y2);
                if (y2 == len - 1 && x2 == len - 1) {
                    return answer;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int nx1 = x1 + dx[dir], ny1 = y1 + dy[dir];
                    int nx2 = x2 + dx[dir], ny2 = y2 + dy[dir];

                    if (isRotation(dir)) {
                        int status = robot.getStatus() ^ 1;

                        if (isValidRotation(nx1, ny1, x2, y2)) {
                            if (!isValid(nx1, ny1) || board[ny1][nx1] == 1 ||
                                    (isVisited[status][ny1][nx1] && isVisited[status][y2][x2])) {
                                continue;
                            }

                            Point p1 = new Point(Math.min(nx1, x2), Math.min(ny1, y2));
                            Point p2 = new Point(Math.max(nx1, x2), Math.max(ny1, y2));

                            if ((status == VERTICAL_STATUS && board[ny1][x1] == 0) ||
                                    (status == HORIZONTAL_STATUS && board[y1][nx1] == 0)) {

                                isVisited[status][ny1][nx1] = isVisited[status][y2][x2] = true;
                                que.offer(new Robot(p1, p2));
                            }
                        } else { // x2, y2가 회전
                            if (!isValid(nx2, ny2) || board[ny2][nx2] == 1 ||
                                    (isVisited[status][ny2][nx2] && isVisited[status][y1][x1])) {
                                continue;
                            }

                            Point p1 = new Point(Math.min(x1, nx2), Math.min(y1, ny2));
                            Point p2 = new Point(Math.max(x1, nx2), Math.max(y1, ny2));

                            if (status == VERTICAL_STATUS && board[ny2][x2] == 0 ||
                                    (status == HORIZONTAL_STATUS && board[y2][nx2] == 0)) {
                                isVisited[status][ny2][nx2] = isVisited[status][y1][x1] = true;
                                que.offer(new Robot(p1, p2));
                            }
                        }
                    } else {
                        int status = robot.getStatus();

                        if (!isValid(nx1, ny1) || !isValid(nx2, ny2) ||
                                board[ny1][nx1] == 1 || board[ny2][nx2] == 1 ||
                                (isVisited[status][ny1][nx1] && isVisited[status][ny2][nx2])) {
                            continue;
                        }

                        isVisited[status][ny1][nx1] = isVisited[status][ny2][nx2] = true;
                        Point p1 = new Point(Math.min(nx1, nx2), Math.min(ny1, ny2));
                        Point p2 = new Point(Math.max(nx1, nx2), Math.max(ny1, ny2));

                        que.offer(new Robot(p1, p2));
                    }
                }
            }
            // System.out.println();
            answer++;
        }
        return -1;
    }

    private boolean isValidRotation(int nx, int ny, int x, int y) {
        return nx == x || ny == y;
    }

    private boolean isRotation(int direction) {
        return direction % 2 != 0;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }
}

class Robot {
    private final int VERTICAL_STATUS = 1;
    private final int HORIZONTAL_STATUS = 0;
    Point p1;
    Point p2;

    public Robot(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isVertical() {
        return p1.x == p2.x;
    }

    public int getStatus() {
        return this.isVertical() ? VERTICAL_STATUS : HORIZONTAL_STATUS;
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
