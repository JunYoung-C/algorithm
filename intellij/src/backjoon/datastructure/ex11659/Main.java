package backjoon.datastructure.ex11659;

import java.io.*;
import java.util.StringTokenizer;

class Section {
    int startIdx;
    int endIdx;

    public Section(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }
}

public class Main {
    public void solution(int n, int[] numbers, int count, Section[] sections) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] sumArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i -  1] + numbers[i];
        }

        for (Section s : sections) {
            bw.write(sumArr[s.endIdx] - sumArr[s.startIdx - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Section[] sections = new Section[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            sections[i] = new Section(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        T.solution(n, numbers, count, sections);
    }
}
