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
                    isVisited[r][c] = true;
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

    private int getHouseCount(Point current, int n, int[][] board) {
        int count = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nx = current.x + dx[dir];
            int ny = current.y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || isVisited[ny][nx] || board[ny][nx] == 0) {
                continue;
            }

            isVisited[ny][nx] = true;
            count += getHouseCount(new Point(nx, ny), n, board);
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
