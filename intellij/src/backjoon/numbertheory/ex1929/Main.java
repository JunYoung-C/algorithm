package backjoon.numbertheory.ex1929;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution(int startNum, int endNum) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isVisited = new boolean[endNum + 1];
        isVisited[1] = true;

        for (int num = 2; num <= endNum; num++) {
            if (!isVisited[num]) {
                for (int i = num * 2; i <= endNum; i += num) {
                    isVisited[i] = true;
                }
            }
        }

        for (int num = startNum; num <= endNum; num++) {
            if (!isVisited[num]) {
                bw.write(num + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());
        T.solution(startNum, endNum);
    }
}
