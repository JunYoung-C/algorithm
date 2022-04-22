package ex2864;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public String solution(String a, String b) {
    String answer = "";
    
    int min = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5'));
    int max = Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6'));
    
    answer = min + " " + max;
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    String a = st.nextToken();
    String b = st.nextToken();
    bw.write(T.solution(a, b)+ "");
    bw.flush();
    bw.close();
  }
}
