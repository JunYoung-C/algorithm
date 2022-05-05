package backjoon.combination.ex1722;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNumber = Integer.parseInt(st.nextToken());
        setFactorial(maxNumber);

        st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());
        int[] numbers = new int[maxNumber + 1];
        boolean[] isUsed = new boolean[maxNumber + 1];

        if (command == 1) { // k번째 순열 출력
            long sequence = Long.parseLong(st.nextToken());

            for (int i = 1; i <= maxNumber; i++) {
                for (int j = 1, cnt = 1; j <= maxNumber; j++) {
                    if (isUsed[j]) {
                        continue;
                    }
                    if (factorial[maxNumber - i] * cnt >= sequence) {
                        numbers[i] = j;
                        isUsed[j] = true;
                        sequence -= factorial[maxNumber - i] * (cnt - 1);
                        break;
                    }
                    cnt++;
                }
            }

            for (int i = 1; i <= maxNumber; i++) {
                bw.write(numbers[i] + " ");
            }

        } else if (command == 2) { // 입력받은 순열의 순서 출력
            for (int i = 1; i <= maxNumber; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            long sequence = 0;

            for (int i = 1; i <= maxNumber; i++) {
                for (int j = 1, cnt = 1; j <= maxNumber; j++) {
                    if (isUsed[j]) {
                        continue;
                    }

                    if (numbers[i] == j) {
                        sequence += factorial[maxNumber - i] * (cnt - 1);
                        isUsed[j] = true;
                        break;
                    }

                    cnt++;
                }
            }

            bw.write(sequence + 1 + "");
        }

        bw.flush();
        bw.close();
    }

    private static void setFactorial(int maxNumber) {
        factorial = new long[maxNumber + 1];
        factorial[0] = 1;
        for (int i = 1; i <= maxNumber; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
