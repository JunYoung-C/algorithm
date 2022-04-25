package backjoon.graph.ex1753;

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
    public int[] solution(int nodeCount, int edgeCount, int startIndex, ArrayList<ArrayList<Node>> graph) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(startIndex, 0));
        distance[startIndex] = 0;

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (distance[now.index] < now.cost) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                if (distance[next.index] > now.cost + next.cost) {
                    distance[next.index] = now.cost + next.cost;
                    pQ.offer(new Node(next.index, distance[next.index]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        int startIndex = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        int a, b, c;
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        int[] minDis = T.solution(nodeCount, edgeCount, startIndex, graph);

        for (int i = 1; i <= nodeCount; i++) {
            if (minDis[i] == Integer.MAX_VALUE) {
                bw.write("INF" + "\n");
            } else {
                bw.write(minDis[i] + "\n");
            }
        }
        for (int dis : minDis) {
        }
        bw.flush();
        bw.close();
    }
}
