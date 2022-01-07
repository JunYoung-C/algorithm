package dfsbfs.ex1707;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  int[] ch;
  boolean answer;
  
  public String solution(int v, int e, ArrayList<ArrayList<Integer>> graph) {
    answer = true; // 이분그래프인 상태
    ch = new int[v + 1]; // -1 : 분할 1번 영역, 0 : 분할 안된 상태(방문 아직 안함), 1 : 분할 2번 영역
    
    for (int node = 1; node <= v; node++) {
      if (ch[node] == 0) { // 분할이 안된 상태인 경우 방문
        ch[node] = 1;
        dfs(node, graph);
      }
    }

    if (answer) {
      return "YES";
    } else {
      return "NO";
    }
  }

  void dfs(int now, ArrayList<ArrayList<Integer>> graph) {
    if (!answer) {
      return;
    }
    
    int nowDivValue = ch[now];
    int nextDivValue = -nowDivValue;
//    System.out.println(nowDivValue + " " + nextDivValue + " " + now);
    
    for (int next : graph.get(now)) {
//      System.out.println(ch[now] + " " +next);

      if (ch[next] == 0) { // 방문 아직 안한 경우
        ch[next] = nextDivValue;
      } else { // 방문 한 경우 
        if (ch[next] == nowDivValue) { 

          answer = false;
          return;
        } else {
          continue;
        }
      }
      
//      for (int i : ch) {
//        System.out.print(i + " ");
//      }
//      System.out.println();
      dfs(next, graph);
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int test = Integer.parseInt(br.readLine());
    for (int t = 0; t < test; t++) {

      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int i = 0; i <= v; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph.get(a).add(b);
        graph.get(b).add(a);
      }

      bw.write(T.solution(v, e, graph) + "\n");
    }

    bw.flush();
    bw.close();
  }
}
