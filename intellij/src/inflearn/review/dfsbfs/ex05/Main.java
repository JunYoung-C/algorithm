package inflearn.review.dfsbfs.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int n, int[] coins, int m) {
        int answer = 0;
        answer = bfs(n, coins, m);

        return answer;
    }

    int bfs(int n, int[] coins, int m) {
        int cnt = 1;
        boolean[] isVisited = new boolean[501];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (coins[i] == m) {
                return cnt;
            }
            isVisited[coins[i]] = true;
            que.offer(coins[i]);
        }
        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                int now = que.poll();

                for (int j = 0; j < n; j++) {
                    int next = now + coins[j];
                    if (m == next) {
                        return cnt + 1;
                    }
                    if (next <= 500 && !isVisited[next]) {
                        isVisited[next] = true;
                        que.offer(next);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = stdIn.nextInt();
        }
        int m = stdIn.nextInt();
        System.out.println(T.solution(n, coins, m));
    }
}
