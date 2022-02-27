package programmers.exam.kakao.year2022.calculateparkingfee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Car {
    String number;
    int inTime;
    String status;
    int parkingTime;

    public Car(String number, int inTime, String status) {
        this.number = number;
        this.inTime = inTime;
        this.status = status;
        parkingTime = 0;
    }

    void addParkingTime(int outTime) {
        parkingTime += (outTime - inTime);
    }

    int getParkingFee(int basicTime, int basicFee, int unitTime, int unitFee) {

        int extraTime = (int) (Math.ceil((double) (this.parkingTime - basicTime) / unitTime));
        if (extraTime < 0) {
            return basicFee;
        }
//        System.out.println(number + " " + parkingTime+ " " + Math.ceil((double)(this.parkingTime - basicTime) / unitTime) + " " + extraTime + " ");
        return basicFee + extraTime * unitFee;
    }
}

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // `차량 번호 : 차` 형태로 매핑
        HashMap<String, Car> carsMap = new HashMap<>();

        // 1. 입출차 기록으로 누적 주차 시간 산출
        for (String record : records) {
            String[] recordArr = record.split(" ");
            int inOutTime = changeStrTimeToIntTime(recordArr[0]);
            String number = recordArr[1];
            String status = recordArr[2];

//            System.out.println(inOutTime + " " + number + " " + status);
            if (!carsMap.containsKey(number)) {
                carsMap.put(number, new Car(number, inOutTime, status));
            } else {
                Car now = carsMap.get(number);
                if (status.equals("IN")) { // 나갔다가 다시 들어오는 경우
                    now.status = status;
                    now.inTime = inOutTime;
                } else {
                    now.addParkingTime(inOutTime);
                    now.status = status;
                }
            }
        }

        // 출차된 내역이 없는 경우 23:59분에 출차한 것으로 간주
        for (Car car : carsMap.values()) {
            if (car.status.equals("IN")) {
                car.addParkingTime(changeStrTimeToIntTime("23:59"));
            }
        }

//        for (Car car : carsMap.values()) {
//            System.out.println(car.number + " " + car.parkingTime);
//        }


        // 2. 누적 주차 시간으로 주차 요금 산출
//        for (Car car : carsMap.values()) {
//            System.out.println(car.getParkingFee(fees[0], fees[1], fees[2], fees[3]));
//        }

        // 3. 차량 번호 오름차순으로 주차 요금 반환
        Object[] keyArr = carsMap.keySet().toArray();
        Arrays.sort(keyArr);
        int len = keyArr.length;
        answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = carsMap.get((String) keyArr[i]).getParkingFee(fees[0], fees[1], fees[2], fees[3]);
        }
        return answer;
    }

    int changeStrTimeToIntTime(String strTime) {
        String[] strTimeArr = strTime.split(":");
        return Integer.parseInt(strTimeArr[0]) * 60 + Integer.parseInt(strTimeArr[1]);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[] fees = {180, 5000, 10, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};

        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        for (int i : T.solution(fees, records)) {
            System.out.print(i + " ");
        }
    }

}
