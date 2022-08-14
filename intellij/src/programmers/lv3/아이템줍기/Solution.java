package programmers.lv3.아이템줍기;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int[][] board = new int[51][51];
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] rectangles, int characterX, int characterY,
                        int itemX, int itemY) {
        int len = rectangles.length;
        for (int r = 0; r <= 50; r++) {
            Arrays.fill(board[r], -1);
        }

        for (int[] rec : rectangles) {
            int c1 = rec[0];
            int r1 = rec[1];
            int c2 = rec[2];
            int r2 = rec[3];
            // 상 : 0, 우 : 1, 하 : 2, 좌 : 3
            for (int c = c1; c < c2; c++) {
                if (board[r1][c] == 0) {
                    continue;
                }
                board[r1][c] = 1;
            }

            for (int r = r1; r < r2; r++) {
                if (board[r][c2] == 1) {
                    continue;
                }
                board[r][c2] = 2;
            }

            for (int c = c2; c > c1; c--) {
                if (board[r2][c] == 2) {
                    continue;
                }
                board[r2][c] = 3;
            }

            for (int r = r2; r > r1; r--) {
                if (board[r][c1] == 3) {
                    continue;
                }
                board[r][c1] = 0;
            }
        }

        // for (int r = 0; r <= 10; r++) {
        //     for (int c = 0; c <= 10; c++) {
        //         System.out.print(board[r][c] + "\t");
        //     }
        //     System.out.println();
        // }

        dfs(characterY, characterX, itemY, itemX, 0);
        dfs(itemY, itemX, characterY, characterX, 0);

        return answer;
    }

    private void dfs(int y, int x, int targetY, int targetX, int count) {
        if (y == targetY && x == targetX) {
            answer = Math.min(answer, count);
            return;
        }

        int dir = board[y][x];
        dfs(y + dy[dir], x + dx[dir], targetY, targetX, count + 1);
    }
}
