package dfsbfs.ex2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int m, ArrayList<ArrayList<Integer>> graph) {
    int answer = 0;
    boolean[] isVisited = new boolean[n + 1];
    Queue<Integer> que = new LinkedList<>();
    que.offer(1);
    isVisited[1] = true;
    
    while (!que.isEmpty()) {
      int now = que.poll();

//      System.out.println(now);
      for (int node : graph.get(now)) {
        if (!isVisited[node]) {
          isVisited[node] = true;
          que.offer(node);
          answer++;
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
    
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    
    bw.write(T.solution(n, m, graph)+ "");
    bw.flush();
    bw.close();
  }
}
