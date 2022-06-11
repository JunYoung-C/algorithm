package backjoon.greedy.ex1744;

import java.io.*;
import java.util.Arrays;

public class Main {
    public int solution(int n, int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int underZeroIndex = - 1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] <= 0) {
                underZeroIndex = i;
            } else {
                break;
            }
        }

        int i = 0;
        for (; i <= underZeroIndex; i += 2) {
            if (i == underZeroIndex) {
                answer += numbers[i];
            } else {
                answer += numbers[i] * numbers[i + 1];
            }
        }

        for (int j = n - 1; j > underZeroIndex; j -= 2) {
            if (j == underZeroIndex + 1) {
                answer += numbers[j];
            } else {
                if (numbers[j] == 1 || numbers[j - 1] == 1) {
                    answer += numbers[j] + numbers[j - 1];
                } else {
                    answer += numbers[j] * numbers[j - 1];
                }
            }
        }

        return answer;
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

        br.close();
        bw.write(T.solution(n, numbers) + "");
        bw.flush();
        bw.close();
    }
}
