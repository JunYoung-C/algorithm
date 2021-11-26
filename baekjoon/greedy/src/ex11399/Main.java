package ex11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public int solution(int n, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    for (int i = n; i >= 1; i--) {
      answer += arr[n-i] * i;
    }
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    String strN = input.readLine();
    int n = Integer.parseInt(strN);
    
    int[] arr = new int[n];
    String[] strArr =input.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }

    print.write(T.solution(n, arr) + "");
    print.flush();
    print.close();
  }
}
