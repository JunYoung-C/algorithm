package programmers.exam.devmatching.year2021.rotation;

import java.util.Scanner;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int qCnt = queries.length;
        int[] answer = new int[qCnt];
        int[][] board = new int[rows + 1][columns + 1];
        int[][] paper = new int[rows + 1][columns + 1];
        for (int y = 1; y < rows + 1; y++) {
            for (int x = 1; x < columns + 1; x++) {
                board[y][x] = (y - 1) * columns + x;
                paper[y][x] = board[y][x];
            }
        }

        for (int i = 0; i < qCnt; i++) {
            int[] q = queries[i];
            answer[i] = rotateAndReturnMin(q[0], q[1], q[2], q[3], board, paper);
        }

//        for (int y = 1; y < rows + 1; y++) {
//            for (int x = 1; x < columns + 1; x++) {
//                System.out.print(board[y][x] + " ");
//            }
//            System.out.println();
//        }
        return answer;
    }

    private int rotateAndReturnMin(int y1, int x1, int y2, int x2, int[][] board, int[][] paper) {
        int tmp = board[y1][x1];
        int min = tmp;

        // 왼쪽 열 상으로 이동
        for (int y = y1; y < y2; y++) {
            board[y][x1] = board[y + 1][x1];
            if (min > board[y][x1]) {
                min = board[y][x1];
            }
        }
        // 아래 행 좌로 이동
        for (int x = x1; x < x2; x++) {
            board[y2][x] = board[y2][x + 1];
            if (min > board[y2][x]) {
                min = board[y2][x];
            }
        }

        // 오른쪽 열 하로 이동
        for (int y = y2; y > y1; y--) {
            board[y][x2] = board[y - 1][x2];
            if (min > board[y][x2]) {
                min = board[y][x2];
            }
        }

        // 위의 행 우로 이동
        for (int x = x2; x > x1; x--) {
            board[y1][x] = board[y1][x - 1];
            if (min > board[y1][x]) {
                min = board[y1][x];
            }
        }

        if (x1 + 1 <= x2) {
            board[y1][x1 + 1] = tmp;
        }



//        for (int y = y1; y <= y2; y++) {
//            for (int x = x1; x <= x2; x++) {
//                if (y == y1 && x >= x1 && x < x2) { // 우로 이동
//                    paper[y][x + 1] = board[y][x];
//                    min = Math.min(min, board[y][x]);
//                } else if (x == x2 && y >= y1 && y < y2) { // 아래로
//                    paper[y + 1][x] = board[y][x];
//                    min = Math.min(min, board[y][x]);
//                } else if (y == y2 && x <= x2 && x > x1) { // 좌로
//                    paper[y][x - 1] = board[y][x];
//                    min = Math.min(min, board[y][x]);
//                } else if (x == x1 && y <= y2 && y > y1) { // 위로
//                    paper[y - 1][x] = board[y][x];
//                    min = Math.min(min, board[y][x]);
//                }
//            }
//        }

//        for (int y = y1; y <= y2; y++) {
//            for (int x = x1; x <= x2; x++) {
//                board[y][x] = paper[y][x];
//            }
//        }

        return min;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5, 1, 6, 3}};

//        int rows = 3;
//        int columns = 3;
//        int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};

//        int rows = 100;
//        int columns = 97;
//        int[][] queries = {{1, 1, 100, 97}};

        for (int i: T.solution(rows, columns, queries)) {
            System.out.print(i + " ");
        }
    }
}
