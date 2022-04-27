package backjoon.graph.ex1197;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] roots;
    public int solution(int nodeCount, int edgeCount, Edge[] edges) {
        int answer = 0;
        int count = 0;
        roots = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            roots[i] = i;
        }

        Arrays.sort(edges);

        for (Edge e : edges) {
            int fa = find(e.start);
            int fb = find(e.end);

            if (fa != fb) {
                unite(fa, fb);
                answer += e.cost;
                count++;
                if (count == nodeCount - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    private int find(int a) {
        if (a == roots[a]) {
            return a;
        }
        return roots[a] = find(roots[a]);
    }

    private void unite(int a, int b) {
        int fa = roots[a];
        int fb = roots[b];
        roots[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[edgeCount];
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }


        bw.write(T.solution(nodeCount, edgeCount, edges) + "");
        bw.flush();
        bw.close();
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
