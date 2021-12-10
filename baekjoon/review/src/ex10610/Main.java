package ex10610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public String solution(String str) {
    String answer = "";
    
    char[] charArr = str.toCharArray();
    Arrays.sort(charArr);
    
    if (charArr[0] != '0') return "-1";
    
    int sum = 0;
    for (char c : charArr) {
      sum += c - '0';
    }
    if (sum % 3 != 0) return "-1";
    
    StringBuffer sb = new StringBuffer(new String(charArr));
    answer = sb.reverse().toString();
    
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    
    bw.write(T.solution(str)+ "");
    bw.flush();
    bw.close();
  }
}


