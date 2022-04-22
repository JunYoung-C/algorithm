package backjoon.datastructure.ex1253;

import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] numbers, int n) {
        if (n <= 2) {
            return 0;
        }

        int count = 0;
        Arrays.sort(numbers);

        int lt, rt;
        for (int target = 0; target < n; target++) {
            lt = 0;
            rt = n - 1;

            int sum;
            while (lt < rt) {
                sum = numbers[lt] + numbers[rt];
                if (sum == numbers[target]) {
                    if (lt != target && rt != target) {
                        count++;
                        break;
                    } else if (lt == target) {
                        lt++;
                    } else {
                        rt--;
                    }
                } else if (sum > numbers[target]) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }

        return count;
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
        bw.write(T.solution(numbers, n) + "");
        bw.flush();
        bw.close();
    }
}
