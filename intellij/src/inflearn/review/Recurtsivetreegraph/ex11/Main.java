package inflearn.review.Recurtsivetreegraph.ex11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int[] solution(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        int[] answer = new int[n + 1];
        bfs(1, answer, graph);
        return answer;
    }

    void bfs(int start, int[] isVisit, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> que = new LinkedList<>();
        isVisit[start] = -1;
        que.offer(start);
        int L = 1;

        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                int now = que.poll();
                for (int next : graph.get(now)) {
                    if (isVisit[next] == 0) {
                        isVisit[next] = L;
                        que.offer(next);
                    }
                }
            }

            L++;
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            graph.get(a).add(b);
        }

        int[] result = T.solution(n, m, graph);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + ":" + result[i]);
        }
    }
}
