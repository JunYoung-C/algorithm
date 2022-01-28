package inflearn.review.dfsbfs.ex06;

import java.util.Scanner;

public class Main {
    int[] ch;
    boolean[] isVisited;

    public void solution(int n, int m, int[] arr) {
        ch = new int[m];
        isVisited = new boolean[11];
        dfs(0, n, m, arr);
    }

    void dfs(int L, int n, int m, int[] arr) {
        if (L >= m) {
            for (int i : ch) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    ch[L] = arr[i];
                    dfs(L + 1, n, m, arr);
                    isVisited[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
        }
        T.solution(n, m, arr);
    }
}