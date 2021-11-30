package ex1946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Exam implements Comparable<Exam> {
  int f;
  int s;

  public Exam(int f, int s) {
    super();
    this.f = f;
    this.s = s;
  }

  @Override
  public int compareTo(Exam o) {
    return this.f - o.f;
  }
}


public class Main {
  public int solution(int n, ArrayList<Exam> exams) {
    int answer = 0;
    int lowRank = Integer.MAX_VALUE;
    Collections.sort(exams);
    for (Exam exam : exams) {
      int rank = exam.s;
      if (rank < lowRank) {
        lowRank = rank;
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int test = 0; test < t; test++) {
      int n = Integer.parseInt(br.readLine());
      ArrayList<Exam> exams = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        exams.add(new Exam(first, second));
      }
      bw.write(T.solution(n, exams) + "\n");
    }


    bw.flush();
    bw.close();
  }
}
