package programmers.kakao.lv3.셔틀버스;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        Arrays.sort(timetable);
        int suttleTime = 9 * 60;
        int i = 0, len = timetable.length;

        while (n > 0) {
            for (; i < len; i++) {
                int crewTime = getMinuteTime(timetable[i]);
                if (suttleTime >= crewTime) {
                    pQ.offer(crewTime);
                } else {
                    break;
                }
            }

            if (n == 1) {
                // 마지막 셔틀버스
                int count = 0;
                while (!pQ.isEmpty() && count < m - 1 && pQ.peek() <= suttleTime) {
                    pQ.poll();
                    count++;
                }

                // System.out.println(pQ.size() + " " + suttleTime);

                if (pQ.isEmpty()) {
                    answer = suttleTime;
                } else {
                    if (pQ.peek() > suttleTime) {
                        answer = suttleTime;
                    } else {
                        answer = pQ.peek() - 1;
                    }
                }
            } else {
                int count = 0;
                while (!pQ.isEmpty() && count < m && pQ.peek() <= suttleTime) {
                    pQ.poll();
                    count++;
                }
            }

            suttleTime += t;
            n--;
        }

        return getStringTime(answer);
    }

    private String getStringTime(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour + ":");

        int minute = time % 60;
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute);

        return sb.toString();
    }

    private int getMinuteTime(String timeStr) {
        String[] splitTime = timeStr.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}
