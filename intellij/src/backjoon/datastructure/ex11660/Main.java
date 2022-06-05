package backjoon.datastructure.ex11660;

import java.io.*;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int[][] table;
    static int[][] sumTable;

    public int solution(int n, Point startPoint, Point endPoint) {
        return sumTable[endPoint.row][endPoint.col]
                - sumTable[endPoint.row][startPoint.col - 1]
                - sumTable[startPoint.row - 1][endPoint.col]
                + sumTable[startPoint.row - 1][startPoint.col - 1];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());

        table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initSumTable(n);

        for (int i = 0; i < sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            bw.write(T.solution(n, new Point(y1, x1), new Point(y2, x2)) + "\n");

        }

        bw.flush();
        bw.close();
    }

    private static void initSumTable(int n) {
        sumTable = new int[n + 1][n + 1];
        // 가로 방향으로 합
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                sumTable[row][col] = sumTable[row][col - 1] + table[row][col];
            }
        }

        // 세로 방향으로 합
        for (int col = 1; col <= n; col++) {
            for (int row = 1; row <= n; row++) {
                sumTable[row][col] += sumTable[row - 1][col];
            }
        }
    }
}
