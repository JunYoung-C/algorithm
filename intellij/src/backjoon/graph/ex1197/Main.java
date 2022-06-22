package backjoon.graph.ex1197;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }

}

public class Main {
    public int solution(int nodeCount, int edgeCount, ArrayList<Edge> edges) {
        int answer = 0;
        Collections.sort(edges);
        int[] parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        for (Edge e : edges) {
            int findStart = find(e.start, parent);
            int findEnd = find(e.end, parent);

            if (findStart != findEnd) {
                unite(findStart, findEnd, parent);
                answer += e.cost;
            }
        }

        return answer;
    }

    private int find(int a, int[] parent) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a], parent);
    }

    private void unite(int a, int b, int[] parent) {
        int fa = find(a, parent);
        int fb = find(b, parent);

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
        int edgeCount = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        br.close();
        bw.write(T.solution(nodeCount, edgeCount, edges)+ "");
        bw.flush();
        bw.close();
    }
}
