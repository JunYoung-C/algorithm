package inflearn.review.dfsbfs.ex07;

import java.util.Scanner;

public class Main {
    public int solution(int n, int r) {
        int answer = 0;
        answer = combi(n, r);
        return answer;
    }

    int[][] combinations = new int[34][34];
    int combi(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == 1) {
            return combinations[n][r] = n;
        }
        if (n == r || r == 0) {
            return combinations[n][r] = 1;
        }
        return combinations[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int r = stdIn.nextInt();
        System.out.println(T.solution(n, r));
    }
}
