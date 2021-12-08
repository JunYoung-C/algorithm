package ex2847;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(int n, int[] numbers) {
    int answer = 0;

    int[] ch = new int[n];
    ch[n - 1] = numbers[n - 1];
    for (int i = n - 1; i >= 1; i--) {
      if (numbers[i - 1] >= ch[i]) {
        ch[i - 1] = ch[i] - 1;
      } else {
        ch[i - 1] = numbers[i - 1];
      }
    }
    
    for (int i = 0; i < n; i++) {
      answer += numbers[i] - ch[i];
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }

    bw.write(T.solution(n, numbers) + "");
    bw.flush();
    bw.close();
  }
}

