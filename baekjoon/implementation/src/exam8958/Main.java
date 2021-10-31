package exam8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(String str) {
    int answer = 0;
    int cnt = 1;
    int len = str.length();
    if (str.charAt(0) == 'O') {
      answer += cnt;
    } 
    for (int i = 1; i < len; i++) {
      if (str.charAt(i) == 'O') {
        if (str.charAt(i-1) == 'O') {
          cnt++;
        }
        answer += cnt;
      } else {
        cnt = 1;
      }
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
