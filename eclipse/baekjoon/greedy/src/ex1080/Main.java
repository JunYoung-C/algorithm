package ex1080;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  void change(int[][] a, int r, int c) {
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        a[i][j] = (a[i][j] + 1) % 2;
//        System.out.print(a[i][j] + " ");
      }
//      System.out.println();
    }
  }
  
  boolean isSame(int[][] a, int[][] b, int row, int col) {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (a[r][c] != b[r][c]) return false;
      }
    }
    return true;
  }
  public int solution(int row, int col, int[][] a, int[][] b) {
    if (isSame(a, b,row, col)) return 0;
    if (row < 3 || col < 3) return -1;
    
    int answer = 0;
    for (int r = 0; r <= row - 3; r++) {
      for (int c = 0; c <= col-3; c++) {
        if (a[r][c] != b[r][c]) {
          change(a, r, c);
          answer++;
          
          if (isSame(a, b,row, col)) return answer;
        }
      }
      
    }
    return -1;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int[][] a = new int[row][col];
    int[][] b = new int[row][col];
    for (int i = 0; i < row; i++) {
      String[] lines = br.readLine().split("");
      
      for (int j = 0; j < col; j++) {
        a[i][j] = Integer.parseInt(lines[j]); 
      }
    }
    for (int i = 0; i < row; i++) {
      String[] lines = br.readLine().split("");
      
      for (int j = 0; j < col; j++) {
        b[i][j] = Integer.parseInt(lines[j]); 
      }
    }
    

    bw.write(T.solution(row, col, a, b)+ "");
    bw.flush();
    bw.close();
  }
}
