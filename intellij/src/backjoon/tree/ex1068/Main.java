package backjoon.tree.ex1068;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public void solution(int nodeCount, ArrayList<ArrayList<Integer>> tree, int startNode, int deleteNode) {
        if (startNode != deleteNode) {
            dfs(startNode, deleteNode, tree);
        }
    }

    private void dfs(int currentNode, int deleteNode, ArrayList<ArrayList<Integer>> tree) {
        boolean isLeafNode = true;

        for (int next : tree.get(currentNode)) {
            if (next != deleteNode) {
                isLeafNode = false;
                dfs(next, deleteNode, tree);
            }
        }

        if (isLeafNode) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            tree.add(new ArrayList<>());
        }
        int startNode = 0;
        for (int child = 0; child < nodeCount; child++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                startNode = child;
            } else {
                tree.get(parent).add(child);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        br.close();
        T.solution(nodeCount, tree, startNode, deleteNode);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
