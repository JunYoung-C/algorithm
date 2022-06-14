package backjoon.graph.ex1325;

import java.io.*;
import java.util.*;

public class Main {
    int[] visitableNodeCount;

    public ArrayList<Integer> solution(int nodeCount, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> answer = new ArrayList<>();
        visitableNodeCount = new int[nodeCount + 1];

        for (int node = 1; node <= nodeCount; node++) {
            bfs(node, graph, nodeCount);
        }

        int max = Arrays.stream(visitableNodeCount).max().getAsInt();
        for (int node = 1; node <= nodeCount; node++) {
            if (visitableNodeCount[node] == max) {
                answer.add(node);
            }
        }

        return answer;
    }

    private void bfs(int startNode, ArrayList<ArrayList<Integer>> graph, int nodeCount) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(startNode);
        boolean[] isVisited = new boolean[nodeCount + 1];
        isVisited[startNode] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : graph.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    visitableNodeCount[startNode]++;
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

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        br.close();

        for (int node : T.solution(nodeCount, graph)) {
            bw.write(node + " ");

        }
        bw.flush();
        bw.close();
    }
}
