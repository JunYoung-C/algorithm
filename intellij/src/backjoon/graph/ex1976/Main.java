package backjoon.graph.ex1976;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public void unite(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fb] = fa;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int visitNodeCount = Integer.parseInt(br.readLine());
        parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        for (int currentNode = 1; currentNode <= nodeCount; currentNode++) {
            st = new StringTokenizer(br.readLine());
            for (int nextNode = 1; nextNode <= nodeCount; nextNode++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (currentNode == nextNode) {
                    continue;
                }

                if (isConnected == 1) {
                    T.unite(currentNode, nextNode);
                }
            }
        }

        String answer = "YES";
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (T.find(a) != T.find(b)) {
            answer = "NO";
        }

        while (st.hasMoreTokens()) {
            a = b;
            b = Integer.parseInt(st.nextToken());

            if (T.find(a) != T.find(b)) {
                answer = "NO";
                break;
            }

        }

        br.close();
        bw.write(answer+ "");
        bw.flush();
        bw.close();
    }
}
