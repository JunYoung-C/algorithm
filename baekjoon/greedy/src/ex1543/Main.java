package ex1543;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(String a, String b) {
    int answer = 0;
    int aLen = a.length();
    int bLen = b.length();

    int i = 0;
    while (i <= aLen - bLen) {
      if (a.substring(i, i+bLen).equals(b)) {
        answer++;
        i = i + bLen;
      } else {
        i++;
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String a = br.readLine();
    String b = br.readLine();
    bw.write(T.solution(a, b) + "");
    bw.flush();
    bw.close();
  }
}

