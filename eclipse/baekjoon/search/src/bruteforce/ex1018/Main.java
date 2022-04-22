package bruteforce.ex1018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int width, int height, String[][] board) {
    int answer = Integer.MAX_VALUE;
    String[] firstCase = {"W", "B", "W", "B", "W", "B", "W", "B"};
    String[] secondCase = {"B", "W", "B", "W", "B", "W", "B", "W"};
    for (int startRow = 0; startRow <= height - 8; startRow++) {
      for (int startCol = 0; startCol <= width - 8; startCol++) {
        answer = Math.min(answer, countDiffBoard(board, startRow, startCol, firstCase, secondCase));
        answer = Math.min(answer, countDiffBoard(board, startRow, startCol, secondCase, firstCase));
      }
    }

    return answer;
  }

  int countDiffBoard(String[][] board, int startRow, int startCol, String[] oddCase, String[] evenCase) {
    int cnt = 0;
    
    for (int row = startRow; row < startRow + 8; row++) {
      for (int col = startCol; col < startCol + 8; col++) {
        if ((row - startRow) % 2 == 0) {
          if (!board[row][col].equals(evenCase[col - startCol])) {
            cnt++;
          }
        } else {
          if (!board[row][col].equals(oddCase[col - startCol])) {
            cnt++;
          }
        }
      }
    }
    
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    String[][] board = new String[height][width];
    for (int i = 0; i < height; i++) {
      board[i] = br.readLine().split("");
    }
    bw.write(T.solution(width, height, board) + "");
    bw.flush();
    bw.close();
  }
}

