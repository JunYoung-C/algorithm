package backjoon.bfsdfs.ex2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] isVisited;

    public void solution(int n, int[][] board) {
        int count = 0;
        isVisited = new boolean[n][n];
        ArrayList<Integer> houseCounts = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1 && !isVisited[r][c]) {
                    count++;
                    houseCounts.add(getHouseCount(new Point(c, r), n, board));
                }
            }
        }

        Collections.sort(houseCounts);

        System.out.println(count);
        for (int i : houseCounts) {
            System.out.println(i);
        }
    }

    private int getHouseCount(Point start, int n, int[][] board) {
        int count = 0;
        isVisited[start.y][start.x] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start.x, start.y));

        while (!que.isEmpty()) {
            Point now = que.poll();
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || isVisited[ny][nx] || board[ny][nx] == 0) {
                    continue;
                }

                isVisited[ny][nx] = true;
                que.offer(new Point(nx, ny));
            }
        }

        return count;
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

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        T.solution(n, board);
    }
}
