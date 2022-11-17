package backjoon.bruteforce.ex15686;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static ArrayList<Point> chickenLocations = new ArrayList<>();
    static ArrayList<Point> homeLocations = new ArrayList<>();
    public int solution(int n, int maxChickenCount) {
        int answer = Integer.MAX_VALUE;

        for (int chickenBit = 1; chickenBit < (1 << chickenLocations.size()); chickenBit++) {
            if (Integer.bitCount(chickenBit) == maxChickenCount) {
//                System.out.println(Integer.toBinaryString(chickenBit) + " " + calculateTotalDistance(chickenBit));
                answer = Math.min(calculateTotalDistance(chickenBit), answer);
            }
        }

        return answer;
    }

    private int calculateTotalDistance(int chickenBit) {
        int totalDis = 0;

        for (Point home : homeLocations) {
            int minDis = Integer.MAX_VALUE;

            for (int i = 0; i < chickenLocations.size(); i++) {
                if (((1 << i) & chickenBit) > 0) {
                    minDis = Math.min(minDis, getDistance(chickenLocations.get(i), home));
                }
            }

            totalDis += minDis;
        }

        return totalDis;
    }

    private int getDistance(Point chicken, Point home) {
        return Math.abs(chicken.y - home.y) + Math.abs(chicken.x - home.x);
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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                if (board[y][x] == 1) {
                    homeLocations.add(new Point(x, y));
                } else if (board[y][x] == 2) {
                    chickenLocations.add(new Point(x, y));
                }
            }
        }

        br.close();
        bw.write(T.solution(n, m)+ "");
        bw.flush();
        bw.close();
    }
}
