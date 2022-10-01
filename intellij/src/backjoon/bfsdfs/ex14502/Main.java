package backjoon.bfsdfs.ex14502;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] isSelected;
    int answer = 0;
    ArrayList<Point> virusList = new ArrayList<>();

    public int solution(int width, int height, int[][] board) {
        isSelected = new boolean[height][width];
        dfs(0, width, height, board);

        return answer;
    }

    private void dfs(int depth, int width, int height, int[][] board) {
        if (depth >= 3) {
            // 구하기
            answer = Math.max(answer, getSafeCount(width, height, copy(board)));
            return;
        }
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (!isSelected[r][c] && board[r][c] == 0) {
                    isSelected[r][c] = true;
                    board[r][c] = 1;
                    dfs(depth + 1, width, height, board);
                    board[r][c] = 0;
                    isSelected[r][c] = false;
                }
            }
        }
    }

    private int getSafeCount(int width, int height, int[][] board) {
        int count = 0;
        Queue<Point> que = new LinkedList<>();
        for (Point virus : virusList) {
            que.offer(virus);
        }

        while (!que.isEmpty()) {
            Point now = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= width || ny < 0 || ny >= height
                        || board[ny][nx] != 0) {
                    continue;
                }

                board[ny][nx] = 2;
                que.offer(new Point(nx, ny));
            }
        }

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (board[r][c] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private int[][] copy(int[][] board) {
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                copyBoard[r][c] = board[r][c];
            }
        }

        return copyBoard;
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
                if (board[i][j] == 2) {
                    T.virusList.add(T.new Point(j, i));
                }
            }
        }

        br.close();
        bw.write(T.solution(width, height, board) + "");
        bw.flush();
        bw.close();
    }
}
