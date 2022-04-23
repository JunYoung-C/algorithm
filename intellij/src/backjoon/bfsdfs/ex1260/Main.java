package backjoon.bfsdfs.ex1260;

import java.io.*;
import java.util.*;

public class Main {
    boolean[] isVisited;

    public void solution(int nodeCount, int edgeCount, int startNode, ArrayList<ArrayList<Integer>> graph)
            throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (ArrayList<Integer> nodes : graph) {
            Collections.sort(nodes);
        }

        isVisited = new boolean[nodeCount + 1];
        dfs(startNode, graph, bw);
        bw.newLine();
        isVisited = new boolean[nodeCount + 1];
        bfs(startNode, graph, bw);

//        bw.write(+ "");
        bw.flush();
        bw.close();
    }

    private void dfs(int now, ArrayList<ArrayList<Integer>> graph, BufferedWriter bw) throws IOException {
        bw.write(now + " ");
        isVisited[now] = true;

        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                dfs(next, graph, bw);
            }
        }
    }

    private void bfs(int startNode, ArrayList<ArrayList<Integer>> graph, BufferedWriter bw) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        que.offer(startNode);
        bw.write(startNode + " ");
        isVisited[startNode] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : graph.get(now)) {
                if (!isVisited[next]) {
                    bw.write(next + " ");
                    isVisited[next] = true;
                    que.offer(next);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

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

        T.solution(nodeCount, edgeCount, startNode, graph);

    }
}
