package backjoon.bruteforce.ex10819;

import java.util.Scanner;

public class Main {
    boolean[] isVisited;
    int answer = Integer.MIN_VALUE;

    public int solution(int n, int[] numbers) {
        isVisited = new boolean[n];

        for (int i = 0; i < numbers.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(0, 0, numbers[i], numbers);
                isVisited[i] = false;
            }
        }
        return answer;
    }

    private void dfs(int depth, int sum, int leftNumber, int[] numbers) {
        if (depth >= numbers.length - 1) {
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, sum + Math.abs(leftNumber - numbers[i]), numbers[i], numbers);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = stdIn.nextInt();
        }

        System.out.println(T.solution(n, numbers));
    }
}
