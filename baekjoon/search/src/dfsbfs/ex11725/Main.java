package dfsbfs.ex11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  int[] answer;
  boolean[] isVisited;
  public int[] solution(int n, ArrayList<ArrayList<Integer>> graph) {
    answer = new int[n + 1];
    isVisited = new boolean[n + 1];
    isVisited[1] = true;
    
    dfs(1, graph);
    
    return answer;
  }
  
  void dfs(int parent, ArrayList<ArrayList<Integer>> graph) {
    for (int child : graph.get(parent)) {
      if (!isVisited[child]) {
        isVisited[child] = true;
        answer[child] = parent;
        dfs(child, graph);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    int[] arr = T.solution(n, graph);
    for (int i = 2; i <= n; i++) {
      bw.write(arr[i] + "\n");
    }
    bw.flush();
    bw.close();
  }
}
