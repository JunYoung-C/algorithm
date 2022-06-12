package backjoon.numbertheory.ex1929;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int startNum, int endNum) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrimeNumber = new boolean[endNum + 1];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[1] = false;

        for (int num = 2; num <= endNum; num++) {
            if (isPrimeNumber[num]) {
                for (int i = num * 2; i <= endNum; i += num) {
                    isPrimeNumber[i] = false;
                }
            }
        }

        for (int num = startNum; num <= endNum; num++) {
            if (isPrimeNumber[num]) {
                primes.add(num);
            }
        }

        return primes;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());

        br.close();
        for (int num : T.solution(startNum, endNum)) {
            bw.write(num+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
