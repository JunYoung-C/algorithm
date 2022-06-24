package backjoon.tree.ex11725;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    boolean[] isVisited;
    public void solution(int nodeCount, ArrayList<ArrayList<Integer>> tree) {
        parent = new int[nodeCount + 1];
        isVisited = new boolean[nodeCount + 1];

        dfs(1, tree);
    }

    private void dfs(int currentNode, ArrayList<ArrayList<Integer>> tree) {
        for (int next : tree.get(currentNode)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                parent[next] = currentNode;
                dfs(next, tree);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        br.close();
        T.solution(nodeCount, graph);
        for (int i = 2; i <= nodeCount; i++) {
            bw.write(parent[i]+ "\n");

        }
        bw.flush();
        bw.close();
    }
}
