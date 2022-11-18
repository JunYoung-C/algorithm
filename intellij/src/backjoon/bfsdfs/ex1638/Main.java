package backjoon.bfsdfs.ex1638;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    boolean[][] isOutside;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    Queue<Point> meltQue = new LinkedList<>();

    public int solution(int width, int height, int[][] board) {
        isOutside = new boolean[height][width];
        checkOutside(width, height, board, 0, 0);

        return getMeltTime(width, height, board);
    }

    private int getMeltTime(int width, int height, int[][] board) {
        int time = 0;
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                if (canMelt(x, y, board)) {
//                    meltQue.offer(new Point(x, y));
//                }
//            }
//        }

        int operationCount = 0;
        while (!meltQue.isEmpty()) {
            int size = meltQue.size();

            for (int i = 0; i < size; i++) {
                Point now = meltQue.poll();
                if (board[now.y][now.x] == 0) {
                    continue;
                }

                board[now.y][now.x] = 0;
                isOutside[now.y][now.x] = true;

                operationCount++;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (!isValid(width, height, nx, ny)) {
                        continue;
                    }

                    if (canMelt(nx, ny, board)) {
                        meltQue.offer(new Point(nx, ny));
                    } else if (isUncheckedOutside(nx, ny, board)) {
                        checkOutside(width, height, board, nx, ny);
                    }
                }
            }

            if (operationCount == 0) {
                break;
            }
            time++;
            operationCount = 0;
        }

        return time;
    }

    private boolean isValid(int width, int height, int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;
        }
        return true;
    }

    private boolean canMelt(int x, int y, int[][] board) {
        if (board[y][x] != 1) {
            return false;
        }
        int outsideCount = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isOutside[ny][nx]) {
                outsideCount++;
            }
        }

        if (outsideCount >= 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isUncheckedOutside(int x, int y, int[][] board) {
        if (board[y][x] == 0 && !isOutside[y][x]) {
            return true;
        }
        return false;
    }

    private void checkOutside(int width, int height, int[][] board, int x, int y) {
        isOutside[y][x] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        while (!que.isEmpty()) {
            Point now = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (!isValid(width, height, nx, ny)) {
                    continue;
                }

                if (board[ny][nx] == 0 && !isOutside[ny][nx]) {
                    isOutside[ny][nx] = true;
                    que.offer(new Point(nx, ny));
                } else if (canMelt(nx, ny, board)) {
                    meltQue.offer(new Point(nx, ny));
                }
            }
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

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] board = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(width, height, board) + "");
        bw.flush();
        bw.close();
    }
}
