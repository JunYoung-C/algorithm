package ex2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public int solution(int n) {
    int[] arr = new int[n + 1];
    Arrays.fill(arr, Integer.MAX_VALUE);
    arr[3] = 1;
    if (n >= 5)
      arr[5] = 1;
    
    for (int i = 6; i <= n; i++) {
      if (arr[i-3] != Integer.MAX_VALUE) {
        arr[i] = Math.min(arr[i], arr[i-3] + 1);
      }
      
      if (arr[i-5] != Integer.MAX_VALUE) {
        arr[i] = Math.min(arr[i], arr[i-5] + 1);
      }
    }
    return arr[n];
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String str = input.readLine();
    int n = Integer.parseInt(str);
    
    int answer = T.solution(n);
    if (answer == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(answer);
  }
}
