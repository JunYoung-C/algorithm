package backjoon.bruteforce.ex14888;

import java.util.Scanner;

public class Main {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void solution(int n, int[] numbers, int[] operationCounts) {
        dfs(numbers, operationCounts, 1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int[] numbers, int[] operationCounts, int depth, int current) {
        if (depth >= numbers.length) {
            max = Math.max(max, current);
            min = Math.min(current, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operationCounts[i] <= 0) {
                continue;
            }

            operationCounts[i] -= 1;

            if (i == 0) {
                dfs(numbers, operationCounts, depth + 1, current + numbers[depth]);
            } else if (i == 1) {
                dfs(numbers, operationCounts, depth + 1, current - numbers[depth]);
            } else if (i == 2) {
                dfs(numbers, operationCounts, depth + 1, current * numbers[depth]);
            } else {
                dfs(numbers, operationCounts, depth + 1, current / numbers[depth]);
            }

            operationCounts[i] += 1;
        }
    }

    public String solution() {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = stdIn.nextInt();
        }

        int[] operationCounts = new int[4];
        for (int i = 0; i < 4; i++) {
            operationCounts[i] = stdIn.nextInt();
        }

        T.solution(n, numbers, operationCounts);
    }
}
