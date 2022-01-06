package dfsbfs.ex2644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  int answer  = -1;
  boolean[] isVisited;
  public int solution(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> graph) {
    isVisited = new boolean[n + 1];
    isVisited[a] = true;
    dfs(a, b, graph, 0);
    return answer;
  }
  
  void dfs(int now, int end, ArrayList<ArrayList<Integer>> graph, int cnt) {
    if (now == end) {
      answer = cnt;
      return;
    } else {
      for (int node : graph.get(now)) {
        if (!isVisited[node]) {
          isVisited[node] = true;
          dfs(node, end, graph, cnt + 1);
          isVisited[node] = false;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      
      graph.get(x).add(y);
      graph.get(y).add(x);
    }
    
    bw.write(T.solution(n, m, a, b, graph)+ "");
    bw.flush();
    bw.close();
  }
}
