package stackandqueue.ex03;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public int solution(int n, int[][] board, int m, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<Integer>();

    for (int move : moves) {
      int num = findNum(n, move, board);

      if (!stack.isEmpty() && stack.peek() == num) {
        stack.pop();
        answer += 2;
      } else if (num != 0) {
        stack.push(num);
      }

    }
    return answer;
  }

  int findNum(int n, int col, int[][] board) {
    int answer = 0;

    for (int r = 0; r < n; r++) {
      if (board[r][col] != 0) {
        answer = board[r][col];
        board[r][col] = 0;
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[][] board = new int[n][n + 1];
    for (int row = 0; row < n; row++) {
      for (int col = 1; col <= n; col++) {
        board[row][col] = stdIn.nextInt();
      }
    }

    int m = stdIn.nextInt();
    int[] moves = new int[m];
    for (int i = 0; i < m; i++) {
      moves[i] = stdIn.nextInt();
    }

    System.out.println(T.solution(n, board, m, moves));
  }
}
