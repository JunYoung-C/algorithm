package inflearn.review.greedy.ex07;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int v;
    int c;

    public Node(int v, int c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}
public class Main {
    public int solution(int n, int e, ArrayList<ArrayList<Node>> graph) {
        int answer = 0;
        int[] myRoot = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            myRoot[i] = i;
        }

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(1, 0));
        int prevV = 0;
        while (!pQ.isEmpty()) {
            Node now = pQ.poll();
            if (find(now.v, myRoot) != find(prevV, myRoot)) {
                answer += now.c;
                unite(prevV, now.v, myRoot);
            } else {
                continue;
            }

            for (Node next : graph.get(now.v)) {
                int fNowV = find(now.v, myRoot);
                int fNextV = find(next.v, myRoot);
                if (fNowV != fNextV) {
                    pQ.offer(next);
                }
            }

            prevV = now.v;
        }
        return answer;
    }

    int find(int me, int[] myRoot) {
        if (myRoot[me] == me) {
            return me;
        } else {
            return myRoot[me] = find(myRoot[me], myRoot);
        }
    }

    void unite(int a, int b, int[] myRoot) {
        int fa = find(a, myRoot);
        int fb = find(b, myRoot);
        if (fa != fb) {
            myRoot[fa] = fb;
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int e = stdIn.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            int c = stdIn.nextInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        System.out.println(T.solution(n, e, graph));
    }
}
