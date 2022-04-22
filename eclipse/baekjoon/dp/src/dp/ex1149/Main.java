package dp.ex1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[][] rgb) {
    int answer = 0;

    for (int y = 1; y < n; y++) {
      rgb[y][0] += Math.min(rgb[y - 1][1], rgb[y - 1][2]);
      rgb[y][1] += Math.min(rgb[y - 1][0], rgb[y - 1][2]);
      rgb[y][2] += Math.min(rgb[y - 1][0], rgb[y - 1][1]);
    }

    answer = Math.min(Math.min(rgb[n - 1][0], rgb[n - 1][1]), rgb[n - 1][2]);
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] rgb = new int[n][n];

    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < 3; x++) {
        rgb[y][x] = Integer.parseInt(st.nextToken());
      }
    }
    bw.write(T.solution(n, rgb) + "");
    bw.flush();
    bw.close();
  }
}
