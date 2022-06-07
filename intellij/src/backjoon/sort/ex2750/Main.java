package backjoon.sort.ex2750;

import java.io.*;

public class Main {
    public int[] solution(int n, int[] numbers) {
//        bubbleSort(n, numbers);
//        selectSort(n, numbers);
        insertSort(n, numbers);

        return numbers;
    }

    private void bubbleSort(int n, int[] numbers) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }

    private void selectSort(int n, int[] numbers) {
        for (int i = 0; i < n - 1; i++) {
            int min = numbers[i];
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (min > numbers[j]) {
                    min = numbers[j];
                    minIdx = j;
                }
            }

            int tmp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = tmp;
        }
    }

    private void insertSort(int n, int[] numbers) {
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
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

        for (int i : T.solution(n, numbers)) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
