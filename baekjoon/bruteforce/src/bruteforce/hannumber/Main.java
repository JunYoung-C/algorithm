package bruteforce.hannumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(int n) {
    int answer = 0;

    for (int i = 1; i <= n; i++) {
      if (isHanNumber(i)) {
        answer++;
      }
    }
    return answer;
  }

  boolean isHanNumber(int num) {
    if (num <= 99)
      return true;

    char[] charArr = String.valueOf(num).toCharArray();
    int len = charArr.length;
    int dif = charArr[0] - charArr[1];
    for (int i = 2; i < len; i++) {
      if (dif != (charArr[i - 1] - charArr[i])) {
        return false;
      }
    }

    return true;
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
