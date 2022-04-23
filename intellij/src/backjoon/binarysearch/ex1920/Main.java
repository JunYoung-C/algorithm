package backjoon.binarysearch.ex1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int solution(int target, int n, int[] numbers) {
        int answer = 0; // 존재하지 않는 경우 0
        int lt = 0, rt = n - 1;
        int mid;
        while (lt <= rt) {
            mid = (lt + rt) / 2;

            if (numbers[mid] == target) {
                return 1;
            } else if (numbers[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
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
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int testCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCount; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(T.solution(target, n, numbers)+ "\n");

        }
        bw.flush();
        bw.close();
    }
}
