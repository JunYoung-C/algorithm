package inflearn.review.dfsbfs.ex02;

import java.util.Scanner;

public class Main {
    int answer = Integer.MIN_VALUE;

    public int solution(int max, int n, int[] arr) {
        dfs(0, 0, max, n, arr);
        return answer;
    }

    void dfs(int L, int sum, int max, int n, int[] arr) {
        if (L >= n) {
            if (sum <= max) {
                answer = Math.max(answer, sum);
                return;
            }
        } else {
            dfs(L + 1, sum + arr[L], max, n, arr);
            dfs(L + 1, sum, max, n, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int max = stdIn.nextInt();
        int n = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(max, n, arr));
    }
}
