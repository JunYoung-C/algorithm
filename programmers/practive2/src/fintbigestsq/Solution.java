package fintbigestsq;

import java.io.IOException;
import java.util.Scanner;

class Solution {
  public int solution(int[][] board) {
    
    int answer = 0;
    int width = board[0].length;
    int height = board.length;
    for (int row = 1; row < height; row++) {
      for (int col = 1; col < width; col++) {
        if (board[row][col] != 0) {
          board[row][col] =
              Math.min(Math.min(board[row - 1][col - 1], board[row][col - 1]), board[row - 1][col])
                  + 1;
        }

      }
    }
    
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
          answer = Math.max(answer, board[row][col]);
      }
    }
    return answer * answer;
  }

  public static void main(String[] args) throws IOException {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    // int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
    int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
    System.out.println(T.solution(board));
  }
}
