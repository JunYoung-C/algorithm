package programmers.kakao.lv1.크레인인형뽑기게임;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][move - 1] == 0) {
                    continue;
                }

                if (!stack.isEmpty() && stack.peek() == board[row][move - 1]) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[row][move - 1]);
                }
                board[row][move - 1] = 0;
                break;
            }
        }

        return answer;
    }
}
