package programmers.kakao.lv3.광고삽입;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Log implements Comparable<Log> {
    int startTime;
    int endTime;

    public Log(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Log o) {
        return this.endTime - o.endTime;
    }
}

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        int playTime = getSecondTime(play_time);
        int advTime = getSecondTime(adv_time);
        int[] playCounts = new int[playTime + 1];

        Arrays.sort(logs);
        ArrayList<Log> logList = createLogList(logs);
        initPlayCount(logs, playTime, playCounts, logList);

        int lt = 0, rt = 0;
        long accumulateTime = 0;
        for (; rt < advTime; rt++) {
            accumulateTime += playCounts[rt];
        }

        long maxAccumulateTime = accumulateTime;

        while (rt <= playTime) {
            accumulateTime += playCounts[rt] - playCounts[lt];
            rt++;
            lt++;
            if (accumulateTime > maxAccumulateTime) {
                maxAccumulateTime = accumulateTime;
                answer = lt;
            }
        }

        return getStringTime(answer);
    }

    private static void initPlayCount(String[] logs, int playTime, int[] playCounts, ArrayList<Log> logList) {
        PriorityQueue<Log> pQ = new PriorityQueue<>();
        int logIdx = 0, len = logs.length;
        for (int time = 0; time <= playTime; time++) {
            while (!pQ.isEmpty() && pQ.peek().endTime == time) {
                pQ.poll();
            }

            while (logIdx < len && logList.get(logIdx).startTime == time) {
                pQ.offer(logList.get(logIdx++));
            }

            playCounts[time] = pQ.size();
        }
    }

    private ArrayList<Log> createLogList(String[] logs) {
        ArrayList<Log> logList = new ArrayList<>();

        for (String log : logs) {
            String[] splitLog = log.split("-");
            logList.add(new Log(getSecondTime(splitLog[0]), getSecondTime(splitLog[1])));
        }

        return logList;
    }

    private String getStringTime(int time) {
        StringBuilder sb = new StringBuilder();
        String hour = time / 3600 + ":";
        time %= 3600;
        String minute = time / 60 + ":";
        if (hour.length() == 2) {
            sb.append("0");
        }
        sb.append(hour);
        if (minute.length() == 2) {
            sb.append("0");
        }
        sb.append(minute);
        if (time < 10) {
            sb.append("0");
        }
        sb.append(time % 60);
        return sb.toString();
    }

    private int getSecondTime(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 3600
                + Integer.parseInt(splitTime[1]) * 60
                + Integer.parseInt(splitTime[2]);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs =
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};


        System.out.println(T.solution(play_time, adv_time, logs));
    }
}
