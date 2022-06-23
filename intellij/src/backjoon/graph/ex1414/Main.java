package backjoon.graph.ex1414;

import java.io.*;
import java.util.PriorityQueue;

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
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    public int solution(int nodeCount, PriorityQueue<Edge> edgePQ) {
        int answer = 0;
        int[] parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        int connectCount = 0;
        while (!edgePQ.isEmpty()) {
            Edge e = edgePQ.poll();
//            System.out.println(e.start + " " + e.end + " " + e.cost);

            if (find(e.start, parent) == find(e.end, parent)) {
                answer += e.cost;
            } else {
                unite(e.start, e.end, parent);
                connectCount++;
            }
        }

        if (connectCount == nodeCount - 1) {
            return answer;
        } else {
            return -1;
        }
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

        int nodeCount = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();

        for (int i = 0; i < nodeCount; i++) {
            String str = br.readLine();
            for (int j = 0; j < nodeCount; j++) {
                char c = str.charAt(j);
                if (c == '0') {
                    continue;
                }

                if (Character.isUpperCase(c)) {
                    edgePQ.add(new Edge(i + 1, j + 1, c - 'A' + 27));
                } else {
                    edgePQ.add(new Edge(i + 1, j + 1, c - 'a' + 1));
                }
            }
        }

        br.close();
        bw.write(T.solution(nodeCount, edgePQ)+ "");
        bw.flush();
        bw.close();
    }
}
