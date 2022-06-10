package backjoon.binarysearch.ex2343;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public long solution(int lectureCount, int size, int[] lectures, long lt, long rt) {
        long answer = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            int sum = 0;
            int tmpSize = 0;
            for (int lecture : lectures) {
                if (sum + lecture > mid) {
                    sum = lecture;
                    tmpSize++;
                } else {
                    sum += lecture;
                }
            }
            if (tmpSize + 1 <= size) {
                answer = mid;
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

        int lectureCount = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] lectures = new int[lectureCount];
        int min = 0;
        int max = 0;
        for (int i = 0; i < lectureCount; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            if (min < lectures[i]) {
                min = lectures[i];
            }
            max += lectures[i];
        }

        br.close();
        bw.write(T.solution(lectureCount, size, lectures, min, max) + "");
        bw.flush();
        bw.close();
    }
}
