package backjoon.datastructure.ex1940;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int target, int[] numbers) {
        int answer = 0;
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int num : numbers) {
            numberMap.put(num, 1);
        }

        for (int num : numbers) {
            if (numberMap.containsKey(target - num)) {
                answer++;
            }
        }

        return answer / 2;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(T.solution(n, target, numbers)+ "");
        bw.flush();
        bw.close();
    }
}
