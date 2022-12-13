package backjoon.graph.ex1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public void solution(int nodeCount, int edgeCount, int startNode, int[][] edges) {
        ArrayList<ArrayList<Node>> graph = createGraph(nodeCount, edges);
        int[] distance = getDistance(nodeCount, startNode, graph);
        for (int i = 1; i <= nodeCount; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private int[] getDistance(int nodeCount, int startNode, ArrayList<ArrayList<Node>> graph) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        distance[startNode] = 0;
        pQ.offer(new Node(startNode, 0));

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (distance[now.index] < now.cost) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                if (distance[next.index] > distance[now.index] + next.cost) {
                    distance[next.index] = distance[now.index] + next.cost;
                    pQ.offer(new Node(next.index, distance[next.index]));
                }
            }
        }

        return distance;
    }

    private ArrayList<ArrayList<Node>> createGraph(int nodeCount, int[][] edges) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new Node(e[1], e[2]));
        }

        return graph;
    }

    class Node implements Comparable<Node> {
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

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        int[][] edges = new int[edgeCount][3];
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new int[] {a, b, c};
        }

        br.close();
        T.solution(nodeCount, edgeCount, startNode, edges);
    }
}
