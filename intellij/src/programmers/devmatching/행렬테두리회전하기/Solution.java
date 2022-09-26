package programmers.devmatching.행렬테두리회전하기;

import java.awt.*;

class Solution {
    int[][] board;
    int width, height;

    public int[] solution(int rows, int columns, int[][] queries) {
        int len = queries.length;
        width = columns;
        height = rows;
        int[] answer = new int[len];
        initBoard();

        for (int i = 0; i < len; i++) {
            Rotation rotation = new Rotation(queries[i]);
            answer[i] = rotation.rotateAndGetMinNum();
        }

//        for (int r = 1; r <= height; r++) {
//            for (int c = 1; c <= width; c++) {
//                System.out.print(board[r][c] + " ");
//            }
//            System.out.println();
//        }

        return answer;
    }

    private void initBoard() {
        board = new int[height + 1][width + 1];

        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                board[r][c] = ((r - 1) * width + c);
            }
        }
    }

    class Rotation {
        Point start;
        Point end;

        public Rotation(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Rotation(int[] query) {
            this(new Point(query[1], query[0]), new Point(query[3], query[2]));
        }

        public int rotateAndGetMinNum() {
            int tmp = board[start.y][start.x];
            int minNum = board[start.y][start.x];

            // 좌
            for (int y = start.y; y < end.y; y++) {
                minNum = Math.min(minNum, board[y + 1][start.x]);
                board[y][start.x] = board[y + 1][start.x];
            }

            // 하
            for (int x = start.x; x < end.x; x++) {
                minNum = Math.min(minNum, board[end.y][x + 1]);

                board[end.y][x] = board[end.y][x + 1];
            }

            // 우
            for (int y = end.y; y > start.y; y--) {
                minNum = Math.min(minNum, board[y - 1][end.x]);

                board[y][end.x] = board[y - 1][end.x];
            }

            // 상
            for (int x = end.x; x > start.x; x--) {
                minNum = Math.min(minNum, board[start.y][x - 1]);

                board[start.y][x] = board[start.y][x - 1];
            }

            board[start.y][start.x + 1] = tmp;

//            for (int r = 1; r <= height; r++) {
//                for (int c = 1; c <= width; c++) {
//                    System.out.print(board[r][c] + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println();

            return minNum;
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

    public static void main(String[] args) {
        Solution T = new Solution();

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        for (int i : T.solution(rows, columns, queries)) {
            System.out.print(i + " ");
        }
    }
}
