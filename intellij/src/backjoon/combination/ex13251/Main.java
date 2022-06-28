package backjoon.combination.ex13251;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public double solution(int colorCount, int totalCount, int[] colors, int tryCount) {
        double answer = 0;

        for (int color : colors) {
            if (color < tryCount) {
                continue;
            }

            int divider = totalCount;
            double multiply = 1;
            for (int i = 0; i < tryCount; i++) {
                multiply *= color--;
            }

            for (int i = 0; i < tryCount; i++) {
                multiply /= divider--;
            }
            answer += multiply;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int colorCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] colors = new int[colorCount];
        int totalCount = 0;
        for (int i = 0; i < colorCount; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            totalCount += colors[i];
        }

        int tryCount = Integer.parseInt(br.readLine());

        br.close();
        bw.write(T.solution(colorCount, totalCount, colors, tryCount)+ "");
        bw.flush();
        bw.close();
    }
}
