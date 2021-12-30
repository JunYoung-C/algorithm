package bruteforce.nqueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
  static int answer = 0;
  boolean[] isVisited;
  ArrayList<Integer> rightDiagonals = new ArrayList<>();
  ArrayList<Integer> leftDiagonals = new ArrayList<>();

  public int solution(int n) {
    isVisited = new boolean[n];

    for (int col = 0; col < n; col++) {
      int rightDiagonal = -col;
      int leftDiagonal = col;

      isVisited[col] = true;
      leftDiagonals.add(leftDiagonal);
      rightDiagonals.add(rightDiagonal);

      dfs(0, col, n);
      isVisited[col] = false;
      leftDiagonals.remove(leftDiagonals.size() - 1);
      rightDiagonals.remove(rightDiagonals.size() - 1);
    }

    return answer;
  }

  void dfs(int nowRow, int nowCol, int n) {
    if (nowRow >= n - 1) {
      answer++;
      return;
    } else {
      for (int nextCol = 0; nextCol < n; nextCol++) {
        int nextRow = nowRow + 1;
        int rightDiagonal = nextRow - nextCol;
        int leftDiagonal = nextRow + nextCol;
        if (!isVisited[nextCol] && !rightDiagonals.contains(rightDiagonal)
            && !leftDiagonals.contains(leftDiagonal)) {
          isVisited[nextCol] = true;
          leftDiagonals.add(leftDiagonal);
          rightDiagonals.add(rightDiagonal);

          dfs(nextRow, nextCol, n);

          isVisited[nextCol] = false;
          leftDiagonals.remove(leftDiagonals.size() - 1);
          rightDiagonals.remove(rightDiagonals.size() - 1);
        }
      }
    }
  }


  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(T.solution(n) + "");
    bw.flush();
    bw.close();
  }
}

