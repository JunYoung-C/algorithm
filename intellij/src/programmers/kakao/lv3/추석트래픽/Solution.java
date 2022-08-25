package programmers.kakao.lv3.추석트래픽;

import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        PriorityQueue<Data> inputQue = new PriorityQueue<>();
        PriorityQueue<Data> outputQue = new PriorityQueue<>();

        for (int i = 0; i < lines.length; i++) {
            String[] splitStr = lines[i].split(" ");
            int outTime = getProcessedTime(splitStr[1]);
            int inTime = calculateInTime(outTime, splitStr[2]);
            String dateString = splitStr[0] + " " + splitStr[1];
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                System.out.println(startDate.getTime());

            } catch(Exception e) {

            }
            inputQue.offer(new Data(i, inTime));
            outputQue.offer(new Data(i, outTime));
            System.out.println(inTime + " " + outTime);
        }

        HashMap<Integer, Boolean> visitMap = new HashMap<>();
        for (int t = 0; t < 24 * 60 * 60 * 1000; t++) {
            while (!inputQue.isEmpty() && inputQue.peek().time < t + 1000) {
                visitMap.put(inputQue.poll().index, true);
            }

            while (!outputQue.isEmpty() && outputQue.peek().time < t) {
                visitMap.remove(outputQue.poll().index);
            }

            // if (visitMap.size() == 2) {
            //     System.out.println(t);
            //     break;
            // }
            answer = Math.max(answer, visitMap.size());
        }

        return answer;
    }

    private int calculateInTime(int outTime, String process) {
        int processedTime = (int)(Double.parseDouble(process.substring(0, process.length() - 1)) * 1000);
        return outTime - processedTime + 1;
    }

    private int getProcessedTime(String str) {
        int time = 0;
        String[] splitTime = str.split(":");
        time = Integer.parseInt(splitTime[0]) * 60;
        time = (Integer.parseInt(splitTime[1]) + time) * 60;
        time = (int)(time * 1000 + Double.parseDouble(splitTime[2]) * 1000);

        return time;
    }
}

class Data implements Comparable<Data> {
    int index;
    int time;

    public Data(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Data o) {
        return this.time - o.time;
    }
}
