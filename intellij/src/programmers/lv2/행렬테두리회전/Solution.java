package programmers.lv2.행렬테두리회전;

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] board = new int[rows + 1][columns + 1];
        for (int row = 1; row <= rows; row++) { // board 초기화
            for (int col = 1; col <= columns; col++) {
                board[row][col] = ((row-1) * columns + col);
            }
        }

        ArrayList<Integer> minNumbers = new ArrayList<>();
        int min;
        for (int[] query : queries) { // query = r1, c1, r2, c2
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            // r1, c1 저장
            int tmp = board[r1][c1];
            min = tmp;

            // 왼쪽열 위로 이동 r--
            for (int row = r1; row < r2; row++) {
                board[row][c1] = board[row + 1][c1];
                if (min > board[row][c1]) {
                    min = board[row][c1];
                }
            }

            // 아래열 좌로 이동 c--
            for (int col = c1; col < c2; col++) {
                board[r2][col] = board[r2][col + 1];
                if (min > board[r2][col]) {
                    min = board[r2][col];
                }
            }

            // 오른쪽열 아래로 이동 r++
            for (int row = r2; row > r1; row--) {
                board[row][c2] = board[row - 1][c2];
                if (min > board[row][c2]) {
                    min = board[row][c2];
                }
            }

            // 위쪽열 우로 이동 c++
            for (int col = c2; col > c1; col--) {
                board[r1][col] = board[r1][col - 1];
                if (min > board[r1][col]) {
                    min = board[r1][col];
                }
            }

            board[r1][c1 + 1] = tmp;
            minNumbers.add(min);
        }

        int len = minNumbers.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = minNumbers.get(i);
        }

        return answer;
    }
}
