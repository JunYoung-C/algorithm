package exam8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(String str) {
    int answer = 0;
    int cnt = 0;
    int len = str.length();

    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == 'O') {
        cnt++;
      } else {
        cnt = 0;
      }
      answer += cnt;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(input.readLine());
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.readLine();
    }
    for (int i = 0; i < n; i++) {
      print.write(T.solution(arr[i]) + "\n");
    }

    print.flush();
    print.close();
  }
}
