package backjoon.numbertheory.ex1456;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited; // false인 경우 소수

    public int solution(long startNum, long endNum) {
        int answer = 0;
        filterPrime();

        for (int num = 2; num < isVisited.length; num++) {
            if (isVisited[num]) {
                continue;
            }

            int exponent = 2;
            while (Math.pow(num, exponent) <= endNum) {
                if (Math.pow(num, exponent) >= startNum) {
                    answer++;
                }
                exponent++;
            }
        }

        return answer;
    }

    private void filterPrime() {
        int len = isVisited.length;
        for (int num = 2; num < len; num++) {
            if (!isVisited[num]) {
                for (int i = num * 2; i < len; i += num) {
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long startNum = Long.parseLong(st.nextToken());
        long endNum = Long.parseLong(st.nextToken());

        isVisited = new boolean[(int) Math.sqrt(endNum) + 1];
        isVisited[1] = true;

        br.close();
        bw.write(T.solution(startNum, endNum) + "");
        bw.flush();
        bw.close();
    }
}
