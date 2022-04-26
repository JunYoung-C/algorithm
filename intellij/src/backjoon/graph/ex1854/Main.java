package backjoon.graph.ex1854;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] isVisited;
    public int[] solution(int nodeCount, int edgeCount, int order, ArrayList<ArrayList<Node>> graph) {
        int[] nthDis = new int[nodeCount + 1];
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(1, 0));

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (isVisited[now.index] >= order) {
                continue;
            }
            isVisited[now.index]++;
            nthDis[now.index] = now.cost;

            for (Node next : graph.get(now.index)) {
                if (isVisited[next.index] < order) {
                    pQ.offer(new Node(next.index, now.cost + next.cost));
                }
            }
        }

        return nthDis;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        isVisited = new int[nodeCount + 1];

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        int[] minDis = T.solution(nodeCount, edgeCount, order, graph);
        for (int i = 1; i <= nodeCount; i++) {
            if (isVisited[i] < order) {
                bw.write(-1 + "\n");
            } else {
                bw.write(minDis[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
