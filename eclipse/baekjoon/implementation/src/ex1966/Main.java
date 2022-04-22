package ex1966;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Paper {
  int index;
  int priority;

  public Paper(int index, int priority) {
    super();
    this.index = index;
    this.priority = priority;
  }
}


public class Main {
  // n : 문서의 개수, m : 인쇄 순서가 궁금한 문서가 놓여있는 인덱스, arr : n개 문서의 중요도 배열
  public int solution(int n, int m, int[] arr) {
    int answer = 1;
    int[] orders = arr.clone();
    Arrays.sort(orders);

    Queue<Paper> que = new LinkedList<Paper>();
    for (int i = 0; i < n; i++) {
      que.add(new Paper(i, arr[i]));
    }

    for (int i = n - 1; i >= 0; i--) {
      int max = orders[i];

      while (!que.isEmpty()) {
        Paper now = que.poll();
        if (now.priority == max) {
          if (now.index == m) {
            return answer;
          }
          answer++;
          break;
        } else {
          que.add(now);
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for (int test = 0; test < t; test++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      bw.write(T.solution(n, m, arr) + "\n");

    }
    bw.flush();
    bw.close();
  }
}
