package inflearn.review.dfsbfs.ex03;

import java.util.Scanner;

public class Main {
    int answer = 0;

    public int solution(int n, int limitTime, int[] points, int[] times) {
        dfs(0, 0, 0, n, limitTime, points, times);

        return answer;
    }

    void dfs(int L, int pointSum, int timeSum, int n, int limitTime, int[] points, int[] times) {
        if (L >= n) {
            answer = Math.max(answer, pointSum);

            return;
        } else {
            if (timeSum + times[L] <= limitTime) {
                dfs(L + 1, pointSum + points[L], timeSum + times[L], n, limitTime, points, times);
            }
            dfs(L + 1, pointSum, timeSum, n, limitTime, points, times);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int limitTime = stdIn.nextInt();
        int[] points = new int[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = stdIn.nextInt();
            times[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(n, limitTime, points, times));
    }
}
