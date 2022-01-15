package dp.ex9251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(String str1, String str2) {
    int answer = 0;
    int len = str1.length();
    char[] arr1 = new char['Z' - 'A' + 1];
    char[] arr2 = new char['Z' - 'A' + 1];
    
    for (int i = 0; i < len; i++) {
      arr1[str1.charAt(i) - 'A'] += 1;
      arr2[str2.charAt(i) - 'A'] += 1;
    }
    
    for (int i = 0; i < 'Z' - 'A' + 1; i++) {
      if (arr1[i] > 0 && arr2[i] > 0) {
        answer += Math.min(arr1[i], arr2[i]);
      }
    }
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    String str2 = br.readLine();
    bw.write(T.solution(str1, str2)+ "");
    bw.flush();
    bw.close();
  }
}