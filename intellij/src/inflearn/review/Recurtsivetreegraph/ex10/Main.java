package inflearn.review.Recurtsivetreegraph.ex10;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    boolean[] isVisited;
    ArrayList<String> roots = new ArrayList<>();

    public int solution(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        dfs(1, n, "", graph);

        int answer = roots.size();
        return answer;
    }

    void dfs(int now, int end, String root, ArrayList<ArrayList<Integer>> graph) {
        if (now == end) {
            if (!roots.contains(root)) {
                roots.add(root);
            }
            return;
        }else {
            for (int next : graph.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    dfs(next, end, root + next, graph);
                    isVisited[next] = false;
                }
            }
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

        System.out.println(T.solution(n, m, graph));
    }
}
