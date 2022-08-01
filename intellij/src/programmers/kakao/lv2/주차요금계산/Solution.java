package programmers.kakao.lv2.주차요금계산;

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // records : "HH:MM 차량번호 내역(IN or OUT)"
        int[] answer = {};
        HashMap<String, Car> carMap = new HashMap<>();
        for (String record : records) {
            String[] recordArr = record.split(" ");
            int time = getMinuteTime(recordArr[0]);
            String carNum = recordArr[1];
            String status = recordArr[2];

            if (!carMap.containsKey(carNum)) {
                carMap.put(carNum, new Car());
            }

            Car car = carMap.get(carNum);
            if (status.equals("IN")) {
                car.parkTime -= time;
            } else {
                car.parkTime += time;
            }
            car.status = status;
        }

        ArrayList<String> carNumbers = new ArrayList<>();
        for (String carNum : carMap.keySet()) {
            Car car = carMap.get(carNum);
            if (car.status.equals("IN")) {
                car.parkTime += 23 * 60 + 59;
                car.status = "IN";
            }
            carNumbers.add(carNum);
        }

        Collections.sort(carNumbers);

        // fees : 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        int len = carNumbers.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            Car car = carMap.get(carNumbers.get(i));
            int overTime = Math.max(0, car.parkTime - fees[0]);
            answer[i] = fees[1] + (int)Math.ceil((double)overTime / fees[2]) * fees[3];
        }
        return answer;
    }

    private int getMinuteTime(String str) {
        String[] timeArr = str.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}

class Car {
    String number;
    int parkTime;
    String status;

    public Car() {}

    public Car(String number, int parkTime, String status) {
        this.number = number;
        this.parkTime = parkTime;
        this.status = status;
    }
}
