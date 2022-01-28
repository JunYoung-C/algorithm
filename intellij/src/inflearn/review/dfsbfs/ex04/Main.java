package inflearn.review.dfsbfs.ex04;

import java.util.Scanner;

public class Main {
    public void solution(int n, int m) {
        dfs(0, n, m, "");
    }

    void dfs(int L, int n, int m, String str) {
        if (L >= m) {
            System.out.println(str);
        } else {
            for (int i = 1; i <= n; i++) {
                dfs(L + 1, n, m, str + i + " ");
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
