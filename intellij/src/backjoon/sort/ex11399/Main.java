package backjoon.sort.ex11399;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] times) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (times[j + 1] < times[j]) {
                    int tmp = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = tmp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer += times[i] * (n - i);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(T.solution(n, times)+ "");
        bw.flush();
        bw.close();
    }
}
