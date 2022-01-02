package dfsbfs.ex1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public int solution(int start, int end) {
    if (start == end) {
      return 0;
    }
    int answer = 0;
    Queue<Integer> que = new LinkedList<>();
    boolean[] isVisited = new boolean[100001];
    que.offer(start);
    isVisited[start] = true;

    while (!que.isEmpty()) {
      int len = que.size();

      for (int i = 0; i < len; i++) {
        int now = que.poll();
        int case1 = now - 1;
        int case2 = now + 1;
        int case3 = 2 * now;
        
        if (case1 == end || case2 == end || case3 == end) {
          return answer + 1;
        }
        
        if (isRightLocation(case1, isVisited)) {
          isVisited[case1] = true;
          que.offer(case1);
        }

        if (isRightLocation(case2, isVisited)) {
          isVisited[case2] = true;
          que.offer(case2);
        }

        if (isRightLocation(case3, isVisited)) {
          isVisited[case3] = true;
          que.offer(case3);
        }
      }
      answer++;
    }
    
    return answer;
  }

  boolean isRightLocation(int num, boolean[] isVisited) {
    if (num < 0 || num > 100000) {
      return false;
    }

    if (isVisited[num]) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    bw.write(T.solution(start, end) + "");
    bw.flush();
    bw.close();
  }
}
