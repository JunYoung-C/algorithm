package programmers.kakao.year2022.vanishingstep;

import java.util.Scanner;

class Status {
    boolean isWin;
    int cnt;

    public Status(boolean isWin, int cnt) {
        this.isWin = isWin;
        this.cnt = cnt;
    }
}
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Status status = dfs(aloc[1], aloc[0], bloc[1], bloc[0], 0, board);
        return status.cnt;
    }

    Status dfs(int x1, int y1, int x2, int y2, int depth,int[][] board) {
        boolean isWinAtLeastOnce = false;
        int maxCnt = depth;
        int minCnt = Integer.MAX_VALUE;

        for (int direction = 0; direction < 4; direction++) {
            int nx1 = x1 + dx[direction];
            int ny1 = y1 + dy[direction];

            if (isValid(x1, y1, nx1, ny1, board)) {
                board[y1][x1] = 0;

                Status nextPlayerStatus = dfs(x2, y2, nx1, ny1, depth + 1, board);

                if (nextPlayerStatus.isWin) {
                    maxCnt = Math.max(maxCnt, nextPlayerStatus.cnt);

                } else {
                    isWinAtLeastOnce = true;
                    minCnt = Math.min(minCnt, nextPlayerStatus.cnt);
                }
                board[y1][x1] = 1;
            }
        }

        return new Status(isWinAtLeastOnce, isWinAtLeastOnce ? minCnt : maxCnt);
    }

    boolean isValid(int x, int y, int nx, int ny, int[][] board) {
        int width = board[0].length;
        int height = board.length;
        if (board[y][x] == 1 && nx >= 0 && nx < width && ny >= 0 && ny < height && board[ny][nx] == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};

//        int[][] board = {{1,1,1},{1,0,1},{1,1,1}};
//        int[] aloc = {1, 0};
//        int[] bloc = {1, 2};

//        int[][] board = {{1,1,1,1,1}};
//        int[] aloc = {0, 0};
//        int[] bloc = {0, 4};

//        int[][] board = {{1}};
//        int[] aloc = {0, 0};
//        int[] bloc = {0, 0};
        System.out.println(T.solution(board, aloc, bloc));
    }
}
