package template.graph.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

public class Main {
    public int solution(int nodeCount, int edgeCount, ArrayList<ArrayList<Node>> graph, int start, int end) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pQ.isEmpty()) {
            Node currentNode = pQ.poll();

            if (distance[currentNode.index] < currentNode.cost) {
                continue;
            }

            for (Node nextNode : graph.get(currentNode.index)) {
                if (distance[nextNode.index] > distance[currentNode.index] + nextNode.cost) {
                    distance[nextNode.index] = distance[currentNode.index] + nextNode.cost;
                    pQ.offer(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(T.solution(nodeCount, edgeCount, graph, start, end) + "");
        bw.flush();
        bw.close();
    }
}
