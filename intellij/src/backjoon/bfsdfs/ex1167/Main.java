package backjoon.bfsdfs.ex1167;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int destination;
    int cost;

    public Edge(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

public class Main {
    int maxIndex = 0;
    long answer = 0;
    boolean[] isVisited;

    public long solution(int n, ArrayList<ArrayList<Edge>> graph) {

        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        dfs(0, 1, graph);

        isVisited = new boolean[n + 1];
        isVisited[maxIndex] = true;
        dfs(0, maxIndex, graph);

        return answer;
    }

    private void dfs(int cost, int currentIndex, ArrayList<ArrayList<Edge>> graph) {
        if (answer < cost) {
            answer = cost;
            maxIndex = currentIndex;
        }
        for (Edge next : graph.get(currentIndex)) {
            if (!isVisited[next.destination]) {
                isVisited[next.destination] = true;
                dfs(cost + next.cost, next.destination, graph);
                isVisited[next.destination] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b, c;
            while ((b = Integer.parseInt(st.nextToken())) != -1) {
                c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, c));
            }
        }

        br.close();
        bw.write(T.solution(n, graph) + "");
        bw.flush();
        bw.close();
    }
}
