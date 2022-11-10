package backjoon.bfsdfs.ex2146;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    boolean[][] isVisitedLand;
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    Queue<Point> distanceQue = new LinkedList<>();

    public int solution(int n, int[][] board) {
        int answer = Integer.MAX_VALUE;

        isVisitedLand = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!isVisitedLand[r][c] && board[r][c] == 1) {
                    isVisited = new boolean[n][n];
                    isVisited[r][c] = true;
                    isVisitedLand[r][c] = true;
                    visitLand(c, r, n, board);
                    answer = Math.min(getMinDistance(n, board), answer);
                }
            }
        }

        return answer;
    }

    private int getMinDistance(int n, int[][] board) {
        int distance = 0;

        while (!distanceQue.isEmpty()) {
            int size = distanceQue.size();

            for (int i = 0; i < size; i++) {
                Point now = distanceQue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (!isValid(n, nx, ny)) {
                        continue;
                    }

                    if (!isVisited[ny][nx]) {
                        if (board[ny][nx] == 0) {
                            isVisited[ny][nx] = true;
                            distanceQue.offer(new Point(nx, ny));
                        } else {
                            distanceQue.clear();
                            return distance;
                        }
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    private void visitLand(int x, int y, int n, int[][] board) {
        distanceQue.offer(new Point(x, y));

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isValid(n, nx, ny)) {
                continue;
            }

            if (!isVisitedLand[ny][nx] && board[ny][nx] == 1) {
                isVisitedLand[ny][nx] = true;
                isVisited[ny][nx] = true;
                visitLand(nx, ny, n, board);
            }
        }
    }

    private static boolean isValid(int n, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return true;
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

        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(n, board)+ "");
        bw.flush();
        bw.close();
    }
}
