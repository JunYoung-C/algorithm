package ex2437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public int solution(int n, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      if (arr[i] > answer + 1)
        break;
      answer += arr[i];
    }


    return answer + 1;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];

    int len = st.countTokens();
    for (int i = 0; i < len; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
    }

    bw.write(T.solution(n, arr) + "");
    bw.flush();
    bw.close();
  }
}
