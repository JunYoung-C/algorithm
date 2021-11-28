package ex2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public int solution(int n, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      answer = Math.max(answer, arr[i] * (len - i));
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(T.solution(n, arr));

  }
}
