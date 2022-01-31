package inflearn.review.greedy.ex05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    public int[] solution(int n, int m, ArrayList<ArrayList<Edge>> graph) {
        int[] answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        answer[1] = 0;

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            if (now.cost > answer[now.vex]) {
                continue;
            }

            for (Edge next : graph.get(now.vex)) {
                if (answer[next.vex] > now.cost + next.cost) {
                    answer[next.vex] = now.cost + next.cost;
                    pQ.offer(new Edge(next.vex, answer[next.vex]));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            int c = stdIn.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        int[] dis = T.solution(n, m, graph);
        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : " + "impossible");
            } else {
                System.out.println(i + " : " + dis[i]);
            }
        }
    }
}
