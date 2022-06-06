package backjoon.datastructure.ex1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            int lt = 0, rt = n - 1;

            while (lt < rt) {
                if (lt == i) {
                    lt++;
                    continue;
                } else if (rt == i) {
                    rt--;
                    continue;
                }

                int sum = numbers[lt] + numbers[rt];
                if (sum == numbers[i]) {
                    answer++;
                    break;
                } else if (sum > numbers[i]) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(T.solution(n, numbers)+ "");
        bw.flush();
        bw.close();
    }
}
