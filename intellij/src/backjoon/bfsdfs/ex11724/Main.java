package backjoon.bfsdfs.ex11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    boolean[] isVisited;
    public int solution(int nodeCount, int edgeCount, ArrayList<ArrayList<Integer>> graph) {
        int answer = 0;
        isVisited = new boolean[nodeCount + 1];

        for (int node = 1; node <= nodeCount; node++) {
            if (!isVisited[node]) {
                isVisited[node] = true;
                dfs(node, graph);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int now, ArrayList<ArrayList<Integer>> graph) {
        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                dfs(next, graph);
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
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        br.close();
        bw.write(T.solution(nodeCount, edgeCount, graph) + "");
        bw.flush();
        bw.close();
    }
}
