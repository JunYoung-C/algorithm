package backjoon.bfsdfs.ex13023;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    boolean existFiveFriends = false;
    boolean[] isVisited;
    public int solution(int nodeCount, int edgeCount, ArrayList<ArrayList<Integer>> graph) {
        isVisited = new boolean[nodeCount];

        for (int node = 0; node < nodeCount; node++) {
            if (!isVisited[node]) {
                isVisited[node] = true;
                dfs(0, node, graph);
                isVisited[node] = false;
            }
        }

        return existFiveFriends ? 1 : 0;
    }

    private void dfs(int depth, int now, ArrayList<ArrayList<Integer>> graph) {
        if (existFiveFriends) {
            return;
        }

        if (depth == 4) {
            existFiveFriends = true;
            return;
        }

        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                dfs(depth + 1, next, graph);
                isVisited[next] = false;
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
        for (int i = 0; i < nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        br.close();
        bw.write(T.solution(nodeCount, edgeCount, graph) + "");
        bw.flush();
        bw.close();
    }
}
