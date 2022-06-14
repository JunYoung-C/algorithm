package backjoon.graph.ex1707;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int[] status;
    boolean[] isVisited;
    String answer;

    public void solution(int nodeCount, ArrayList<ArrayList<Integer>> graph) {
        answer = "YES";
        status = new int[nodeCount + 1];
        isVisited = new boolean[nodeCount + 1];

        for (int node = 1; node <= nodeCount; node++) {
            if (!isVisited[node]) {
                status[node] = 1;
                isVisited[node] = true;
                dfs(node, graph);
            }
        }

    }

    private void dfs(int currentNode, ArrayList<ArrayList<Integer>> graph) {
        if (answer.equals("NO")) {
            return;
        }

        for (int next : graph.get(currentNode)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                status[next] = -status[currentNode];
                dfs(next, graph);
            } else if (status[next] == status[currentNode]) {
                answer = "NO";
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
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

            T.solution(nodeCount, graph);
            bw.write(T.answer + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
