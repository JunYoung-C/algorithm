package ex2720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int[] solution(int money) {
    int[] answer = new int[4];
    int[] coins = new int[] {25, 10, 5, 1};
    
    
    for (int i = 0; i < 4; i++) {
      if (money >= coins[i]) {
        answer[i] = money / coins[i];
        money = money % coins[i];
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int money = Integer.parseInt(br.readLine());
      for (int m : T.solution(money)) {
        bw.write(m + " ");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}

