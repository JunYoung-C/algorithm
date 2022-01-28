package inflearn.review.dfsbfs.ex08;

import java.util.Scanner;

public class Main {
    int[] mul;
    int[] ch;
    int[] answer;
    boolean[] isUsed;
    boolean find = false;
    public int[] solution(int n, int f) {
        answer = new int[n];
        mul = new int[n];
        ch = new int[n];
        isUsed = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            mul[i] = combi(n - 1, i);
        }
        dfs(0, n, f);
        return answer;
    }

    void dfs(int L, int n, int f) {
        if (find) {
            return;
        }
        if (L >= n) {
            // 합이 f가 되는지 확인
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += ch[i] * mul[i];
            }
            if (sum == f) {
                answer = ch.clone();
                find = true;
            }
            return;
        } else {
            for (int i = 0; i < n; i++) {
                int num = i + 1;
                if (!isUsed[num]) {
                    ch[L] = num;
                    isUsed[num] = true;
                    dfs(L + 1, n, f);
                    isUsed[num] = false;

                }
            }
        }
    }
    int[][] combi = new int[11][11];
    int combi(int n, int r) {
        if (combi[n][r] != 0) {
            return combi[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return combi[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int f = stdIn.nextInt();
        for (int i : T.solution(n, f)) {
            System.out.print(i + " ");
        }
    }
}
