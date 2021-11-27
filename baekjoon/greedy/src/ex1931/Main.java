package ex1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

class Conf implements Comparable<Conf> {
  int start;
  int end;

  public Conf(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(Conf o) {
    if (this.end == o.end) return this.start - o.start;
    return this.end - o.end;
  }

}


public class Main {
  public int solution(int n, ArrayList<Conf> confs) {
    int answer = 0;
    int endTime = -1;
    Collections.sort(confs);
    for (Conf conf : confs) {
      if (conf.start >= endTime) {
        endTime = conf.end;
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Conf> confs = new ArrayList<>();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      confs.add(new Conf(start, end));
    }
    
    System.out.println(T.solution(n, confs));
  }
}
