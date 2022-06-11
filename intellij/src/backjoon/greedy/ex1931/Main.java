package backjoon.greedy.ex1931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
public class Main {
    public int solution(int n, Meeting[] meetings) {
        int answer = 0;
        int prevMeetingEndTime = 0;
        Arrays.sort(meetings);

        for (Meeting m : meetings) {
            if (prevMeetingEndTime <= m.start) {
                answer++;
                prevMeetingEndTime = m.end;
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
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        br.close();
        bw.write(T.solution(n, meetings)+ "");
        bw.flush();
        bw.close();
    }
}
