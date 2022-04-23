package backjoon.sort.ex2750;

import java.io.*;

public class Main {
    public void solution(int n, int[] numbers) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[minIdx] > numbers[j]) {
                    minIdx = j;
                }
            }

            int tmp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = tmp;
        }

        for (int number : numbers) {
            bw.write(number + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        T.solution(N, numbers);

    }
}
