package backjoon.bfsdfs.ex1260;

import java.io.*;
import java.util.*;

public class Main {
    ArrayList<Integer> dfsResult = new ArrayList<>();
    ArrayList<Integer> bfsResult = new ArrayList<>();
    boolean[] isVisited;
    public void solution(int nodeCount, int edgeCount, int start, ArrayList<ArrayList<Integer>> graph) {
        isVisited = new boolean[nodeCount + 1];
        dfs(start, graph);

        isVisited = new boolean[nodeCount + 1];
        bfs(start, graph);
    }

    private void dfs(int now, ArrayList<ArrayList<Integer>> graph) {
        isVisited[now] = true;
        dfsResult.add(now);

        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                dfs(next, graph);
            }
        }
    }

    private void bfs(int start, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        isVisited[start] = true;
        bfsResult.add(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : graph.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    bfsResult.add(next);
                    que.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= nodeCount; i++) {
            Collections.sort(graph.get(i));
        }

        br.close();
        T.solution(nodeCount, edgeCount, start, graph);
        for (int i : T.dfsResult) {
            bw.write(i + " ");
        }
        bw.newLine();
        for (int i : T.bfsResult) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
