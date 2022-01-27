package inflearn.review.Recurtsivetreegraph.ex06;

import java.util.Scanner;

public class Main {
    boolean[] isVisited;

    public void solution(int n) {
        isVisited = new boolean[n + 1];
        dfs(0, n, 0, "");
    }

    void dfs(int L, int n, int idx, String str) {
        if (L >= n) {
            if (!str.equals("")) {
                System.out.println(str);
            }
            return;
        } else {
            for (int i = idx + 1; i <= n; i++) {
                dfs(L + 1, n, i, str + i + " ");
                dfs(L + 1, n, i, str);
            }
        }
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        T.solution(n);
    }
}
