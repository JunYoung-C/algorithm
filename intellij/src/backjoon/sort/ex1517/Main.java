package backjoon.sort.ex1517;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long changeCount = 0;
    static int[] tmp;
    static int[] numbers;

    static private void mergeSort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = numbers[i];
        }

        int i = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] <= tmp[idx2]) {
                numbers[i++] = tmp[idx1++];
            } else {
                changeCount += idx2 - i;
                numbers[i++] = tmp[idx2++];
            }
        }

        while (idx1 <= m) {
            numbers[i++] = tmp[idx1++];
        }

        while (idx2 <= e) {
            changeCount += idx2 - i;
            numbers[i++] = tmp[idx2++];
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1);
        bw.write(changeCount + "");
        bw.flush();
        bw.close();
    }
}
