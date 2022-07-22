package programmers.lv2.가장큰정사각형찾기;

class Solution {
    public long solution(int [][]board) {
        long answer = 0;
        int width = board[0].length;
        int height = board.length;

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                if (board[row][col] > 0 && board[row - 1][col] > 0 && board[row - 1][col - 1] > 0 && board[row][col - 1] > 0)
                    board[row][col] = Math.min(board[row - 1][col], Math.min(board[row - 1][col - 1], board[row][col - 1])) + 1;
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                answer = Math.max(board[row][col], answer);
            }
        }

        return answer * answer;
    }
}