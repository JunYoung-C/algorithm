package backjoon.dp.ex1504;

import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int nodeCount;
    public int solution(int a, int b) {
        // 1 - a - b - n
        // 1 - b - a - n
        return Math.min(getTotalDistance(nodeCount, a, b), getTotalDistance(nodeCount, b, a));
    }

    private int getTotalDistance(int nodeCount, int a, int b) {
        if (getMinDistance(1, a) != -1 && getMinDistance(a, b) != -1 && getMinDistance(b, nodeCount) != -1) {
            return getMinDistance(1, a) + getMinDistance(a, b) + getMinDistance(b, nodeCount);
        }
        return -1;
    }

    private int getMinDistance(int start, int end) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, 100_000_000);

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        distance[start] = 0;
        pQ.offer(new Node(start, 0));

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (now.cost > distance[now.index]) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                if (distance[next.index] > distance[now.index] + next.cost) {
                    distance[next.index] = distance[now.index] + next.cost;
                    pQ.offer(new Node(next.index, distance[next.index]));
                }
            }
        }

        if (distance[end] == 100_000_000) {
            return -1;
        } else {
            return distance[end];
        }
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

        nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(T.new Node(b, c));
            graph.get(b).add(T.new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(T.solution(a, b)+ "");
        bw.flush();
        bw.close();
    }
}
