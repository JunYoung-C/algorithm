package backjoon.sort.ex10989;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        int[] arr = new int[10001];

        for (int i : numbers) {
            arr[i]++;
        }

        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                bw.write(i+ "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
