package exam03;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public int solution(int n, int[][] board, int m, int[] cols) {
    int answer = 0;
    // 내가 짠 코드
//    // 인형이 있는 행의 위치 저장하는 배열 생성
//    int[] rows = new int[n + 1];
//    for (int col = 1; col  < n + 1; col++) {
//      for (int row = 0; row < n; row++) {
//        if (board[row][col] != 0) {
//          rows[col] = row;
//          break;
//        }
//      }
//    }
//
//    // 스택에 넣기
//      // 인형 터뜨리고 개수 반영하기
//    Stack<Integer> stack = new Stack<>();
//    for (int col : cols) {
//      if (rows[col]  < n) {
//        int value = board[rows[col]++][col];
//        if (!stack.isEmpty() && stack.get(stack.size()-1) == value) {
//          answer += 2;
//          stack.pop();
//        } else {
//          stack.push(value);
//        }
//        
//        
//      } else {
//        stack.push(0);
//      }
//    }

    Stack<Integer> stack = new Stack<>();
    for (int pos : cols) {
      for (int i = 0; i < board.length; i++) {
        if (board[i][pos-1] != 0) {
          int tmp = board[i][pos-1];
          board[i][pos-1] = 0;
          if (!stack.isEmpty() && tmp == stack.peek()) {
            answer += 2;
            stack.pop();
          } else {
            stack.push(tmp);
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
    int n = stdIn.nextInt();
//    int[][] board = new int[n][n + 1];
    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
//      for (int j = 1; j < n + 1; j++) {
//        board[i][j] = stdIn.nextInt();
//      }
      for (int j = 0; j < n; j++) {
        board[i][j] = stdIn.nextInt();
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
