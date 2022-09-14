package programmers.kakao.lv3.추석트래픽;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<Process> processes = new ArrayList<>();
        initProcesses(lines, processes);
        Collections.sort(processes, (o1, o2) -> o1.startTime - o2.startTime);

        ArrayList<Integer> times = createTimeList(processes);
        Collections.sort(times);

        PriorityQueue<Process> pQ = new PriorityQueue<>();
        int index = 0, len = processes.size();

        // for (int i : times) {
        //     System.out.print(i + " ");
        // }

        for (int time : times) {
            while (index < len && processes.get(index).startTime <= time + 999) {
                pQ.offer(processes.get(index++));
            }

            while (!pQ.isEmpty() && pQ.peek().endTime < time) {
                pQ.poll();
            }

            answer = Math.max(answer, pQ.size());
        }

        return answer;
    }

    private void initProcesses(String[] lines, ArrayList<Process> processes) {
        for (String line : lines) {
            processes.add(parseProcess(line));
        }
    }

    private ArrayList<Integer> createTimeList(ArrayList<Process> processes) {
        HashSet<Integer> timeSet = new HashSet<>();

        for (Process process : processes) {
            timeSet.add(process.startTime);
            timeSet.add(process.endTime);
        }

        return new ArrayList<>(timeSet);
    }

    private Process parseProcess(String input) {
        String[] splitInput = input.split(" ");

        int endTime = parseTime(splitInput[1]);
        int startTime = endTime - parseSecond(splitInput[2]) + 1;
        return new Process(startTime, endTime);
    }

    private int parseSecond(String secondStr) {
        secondStr = secondStr.substring(0, secondStr.length() - 1);
        return (int)(Double.parseDouble(secondStr) * 1000);
    }

    private int parseTime(String timeStr) {
        String[] splitTimeStr = timeStr.split(":"); // h, m, s

        int h = Integer.parseInt(splitTimeStr[0]);
        int m = Integer.parseInt(splitTimeStr[1]);
        double s = Double.parseDouble(splitTimeStr[2]);

        return (int)((3600 * h + 60 * m + s) * 1000);
    }
}

class Process implements Comparable<Process> {
    int startTime;
    int endTime;

    public Process(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Process o) {
        if (this.endTime == o.endTime) {
            return this.startTime - o.startTime;
        }

        return this.endTime - o.endTime;
    }
}

