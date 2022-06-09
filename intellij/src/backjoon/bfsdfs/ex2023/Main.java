package backjoon.bfsdfs.ex2023;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> primes = new ArrayList<>();
    public void solution(int n) {
        int answer = 0;

        for (int i = 1; i < 10; i++) {
            if (isPrime(i)) {
                dfs(0, i, n);
            }
        }
    }

    private void dfs(int depth, int number, int n) {
        if (depth == n - 1) {
            primes.add(number);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (isPrime(number * 10 + i)) {
                dfs(depth + 1, number * 10 + i, n);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        br.close();
        T.solution(n);
        for (int num: primes) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
