package backjoon.binarysearch.ex1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] numbers, int target) {
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (numbers[mid] == target) {
                return 1;
            } else if (numbers[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (count-- > 0) {
            bw.write(T.solution(n, numbers, Integer.parseInt(st.nextToken()))+ "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
