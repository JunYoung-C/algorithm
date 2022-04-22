package ex11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
  int time;
  char status;
  
  public Lecture(int time, char status) {
    this.time = time;
    this.status = status;
  }
  
  @Override
  public int compareTo(Lecture o) {
    if (this.time == o.time) return o.status - this.status;
    return this.time - o.time;
  }
}
public class Main {
  public int solution(int n, ArrayList<Lecture> lectures) {
    int answer = 0;
    int cnt = 0;
    Collections.sort(lectures);
    for (Lecture lec: lectures) {
      if (lec.status == 's') {
        cnt++;
      } else {
        cnt--;
      }
      answer = Math.max(answer, cnt);
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    ArrayList<Lecture> lectures = new ArrayList<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      lectures.add(new Lecture(Integer.parseInt(st.nextToken()), 's'));
      lectures.add(new Lecture(Integer.parseInt(st.nextToken()), 't'));
    }

    bw.write(T.solution(n, lectures) + "");
    bw.flush();
    bw.close();
  }
}

