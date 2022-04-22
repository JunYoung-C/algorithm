package ex1783;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int height, int width) {
    if (height <= 0 || width <= 0) return 0;
    int answer = 0;
    
    if (height >= 3) {
      if (width >= 7) {
        answer = width-2;
      } else if (width >= 4) {
        answer = 4;
      } else {
        answer += width;
      }
    } else if (height >= 2){
      answer = (int) Math.ceil((double) width / height);
      if (answer > 4) answer = 4;
    } else {
      answer = 1;
    }
    
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    bw.write(T.solution(height, width)+ "");
    bw.flush();
    bw.close();
  }
}
