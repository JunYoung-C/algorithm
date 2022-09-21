package programmers.kakao.year2022.주차요금계산;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees);
        HashMap<String, Integer> inputTimeMap = new HashMap<>();
        HashMap<String, Integer> parkTimeMap = new HashMap<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");
            int time = parseTime(splitRecord[0]);
            String carNumber = splitRecord[1];
            String status = splitRecord[2];

            if (status.equals("IN")) {
                inputTimeMap.put(carNumber, time);
            } else {
                int parkTime = time - inputTimeMap.get(carNumber);
                parkTimeMap.put(carNumber, parkTimeMap.getOrDefault(carNumber, 0) + parkTime);

                inputTimeMap.remove(carNumber);
            }
        }

        // 나가지 못한 차량은 23:59분에 출차
        int outTime = parseTime("23:59");
        for (String carNumber : inputTimeMap.keySet()) {
            int parkTime = outTime - inputTimeMap.get(carNumber);
            parkTimeMap.put(carNumber, parkTimeMap.getOrDefault(carNumber, 0) + parkTime);
        }

        ArrayList<String> carNumbers = new ArrayList<>(parkTimeMap.keySet());
        int[] answer = new int[carNumbers.size()];

        Collections.sort(carNumbers);

        for (int i = 0; i < carNumbers.size(); i++) {
            int parkTime = parkTimeMap.get(carNumbers.get(i));
            answer[i] = fee.calculate(parkTime);
        }

        return answer;
    }

    private int parseTime(String str) {
        String[] splitStr = str.split(":");
        int hour = Integer.parseInt(splitStr[0]);
        int minute = Integer.parseInt(splitStr[1]);

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        for (int i : T.solution(fees, records)) {
            System.out.print(i + " ");
        }
    }
}

class Fee {
    int basicTime;
    int basicFee;
    int perTime;
    int perFee;

    public Fee(int[] feeInfo) {
        this(feeInfo[0], feeInfo[1], feeInfo[2], feeInfo[3]);
    }

    public Fee(int basicTime, int basicFee, int perTime, int perFee) {
        this.basicTime = basicTime;
        this.basicFee = basicFee;
        this.perTime = perTime;
        this.perFee = perFee;
    }

    public int calculate(int time) {
        if (time <= basicTime) {
            return basicFee;
        } else {
            double remainTime = time - basicTime;
            int extraFee = (int) Math.ceil(remainTime / perTime) * perFee;
            return basicFee + extraFee;
        }
    }
}
