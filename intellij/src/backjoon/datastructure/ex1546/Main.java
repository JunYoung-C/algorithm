package backjoon.datastructure.ex1546;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public double solution(int n, int[] numbers) {
        double answer = 0;
        double max = Arrays.stream(numbers).max().getAsInt();
        for (int i = 0; i < n; i++) {
            answer += numbers[i] / max * 100;
        }

        return answer / n;
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

        bw.write(T.solution(n, numbers)+ "");
        bw.flush();
        bw.close();
    }
}
