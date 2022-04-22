package stack.exam03;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public int solution(int boardLen, int[][] board, int movesLen, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for (int move : moves) {
      for (int row = 0; row < boardLen; row++) {
        int target = board[row][move];
        if (target > 0) {
          board[row][move] = 0;
          if (!stack.isEmpty() && stack.peek() == target) {
            stack.pop();
            answer+=2;
          } else {
            stack.push(target);
          }
          break;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int boardLen = stdIn.nextInt();
    int[][] board = new int[boardLen ][boardLen + 1];
    for (int i = 0; i < boardLen; i++) {
      for (int j = 1; j <= boardLen; j++) {
        board[i][j] = stdIn.nextInt();
      }
    }

    int movesLen = stdIn.nextInt();
    int[] moves = new int[movesLen];
    for (int i = 0; i < movesLen; i++) {
      moves[i] = stdIn.nextInt();
    }

    System.out.println(T.solution(boardLen, board, movesLen, moves));
  }
}
