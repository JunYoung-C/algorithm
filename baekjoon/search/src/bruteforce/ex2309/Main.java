package bruteforce.ex2309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  // public int[] solution(int[] heights) {
  // int[] answer = new int[7];
  // int total = Arrays.stream(heights).sum();
  // int difHeight = total - 100;
  // boolean[] ch = new boolean[9];
  //
  // boolean flag = false;
  // for (int i = 0; i < 8; i++) {
  // for (int j = i + 1; j < 9; j++) {
  // if (heights[i] + heights[j] == difHeight) {
  // ch[i] = true;
  // ch[j] = true;
  // flag = true;
  // break;
  // }
  // }
  //
  // if (flag) {
  // break;
  // }
  // }
  //
  // int idx = 0;
  // for (int i = 0; i < 9; i++) {
  // if (!ch[i]) {
  // answer[idx++] = heights[i];
  // }
  // }
  //
  // Arrays.sort(answer);
  // return answer;
  // }

  public int[] solution(int[] heights) {
    int[] answer = new int[7];
    int total = Arrays.stream(heights).sum();

    boolean flag = false;
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (total - 100 == (heights[i] + heights[j])) {
          heights[i] = -1;
          heights[j] = -1;
          flag = true;
          break;
        }

        if (flag) {
          break;
        }
      }
    }

    Arrays.sort(heights);
    int idx = 0;
    for (int h : heights) {
      if (h != -1) {
        answer[idx++] = h;
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] heights = new int[9];
    for (int i = 0; i < 9; i++) {
      heights[i] = Integer.parseInt(br.readLine());
    }

    for (int i : T.solution(heights)) {
      bw.write(i + "\n");
    }
    bw.flush();
    bw.close();
  }
}
