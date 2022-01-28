package inflearn.review.dfsbfs.ex09;

import java.util.Scanner;

public class Main {
    public void solution(int n, int m) {
        dfs(0, 0, n, m, "");
    }

    void dfs(int L, int now, int n, int m, String str) {
        if (L >= m) {
            System.out.println(str);
        } else {
            for (int i = now + 1; i <= n; i++) {
                dfs(L + 1, i, n, m, str + i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        T.solution(n, m);
    }
}
