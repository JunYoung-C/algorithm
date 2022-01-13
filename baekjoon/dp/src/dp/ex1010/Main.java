package dp.ex1010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int lt, int rt) {
    int answer = 0;
    
    answer = combi(rt, lt);
    return answer;
  }
  
  int[][] combination = new int[31][31];
  public int combi(int n, int r) {
    if (combination[n][r] != 0) {
      return combination[n][r];
    }
    
    if (n == r || r == 0) {
      return combination[n][r] = 1;
    }
    
    if (r == 1) {
      return combination[n][r] = n;
    }
    
    return combination[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
  }
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    int t = Integer.parseInt(br.readLine());
    for (int test = 0; test < t; test++) {
      st = new StringTokenizer(br.readLine());
      int lt = Integer.parseInt(st.nextToken());
      int rt = Integer.parseInt(st.nextToken());
      bw.write(T.solution(lt, rt)+ "\n");

    }
    
    bw.flush();
    bw.close();
  }
}