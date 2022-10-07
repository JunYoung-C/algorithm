package backjoon.dp.ex11660;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public String solution() {
        String answer = "";

        return answer;
    }

    static class Point {
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

        int len = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[][] board = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= len; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[len + 1][len + 1];
        for (int r = 1; r <= len; r++) {
            for (int c = 1; c <= len; c++) {
                dp[r][c] = dp[r][c - 1] + dp[r - 1][c] - dp[r - 1][c - 1] + board[r][c];
            }
        }

        ArrayList<Point[]> commands = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            commands.add(new Point[]{new Point(x1, y1), new Point(x2, y2)});
        }

        for (Point[] cmd : commands) {
            Point p1 = cmd[0];
            Point p2 = cmd[1];

            System.out.println(dp[p2.y][p2.x] - dp[p2.y][p1.x - 1] - dp[p1.y - 1][p2.x] + dp[p1.y - 1][p1.x - 1]);
        }

        br.close();
    }
}
