package backjoon.sort.ex2751;

import java.io.*;

public class Main {
    static int[] tmp;

    private static void mergeSort(int[] numbers, int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(numbers, s, m);
        mergeSort(numbers, m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = numbers[i];
        }

        int idx1 = s;
        int idx2 = m + 1;
        int i = s;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] <= tmp[idx2]) {
                numbers[i++] = tmp[idx1++];
            } else {
                numbers[i++] = tmp[idx2++];
            }
        }

        while (idx1 <= m) {
            numbers[i++] = tmp[idx1++];
        }

        while (idx2 <= e) {
            numbers[i++] = tmp[idx2++];
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        tmp = new int[n];
        mergeSort(numbers, 0, n - 1);
        for (int i : numbers) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
