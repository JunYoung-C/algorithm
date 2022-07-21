package programmers.lv2.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridgeLength, int bridgeWeight, int[] truckWeights) {
        int answer = 0;
        Queue<Truck> bridge = new LinkedList<>();
        int outCount = 0;
        int totalCount = truckWeights.length;
        int totalWeight = 0;
        int index = 0;
        while (true) {
            answer++;
            // inTime 시간이 적절하면 빼고 count++ 하기
            if (!bridge.isEmpty() && answer - bridge.peek().inTime == bridgeLength) {
                outCount++;
                totalWeight -= bridge.poll().weight;
            }

            // 브릿지 길이와 무게가 여유로우면 삽입
            if (index < totalCount && totalWeight + truckWeights[index] <= bridgeWeight) {
                totalWeight += truckWeights[index];
                bridge.offer(new Truck(answer, truckWeights[index]));
                index++;
            }

            // 마지막 트럭이 나오면 종료
            if (totalCount == outCount) {
                break;
            }
        }

        return answer;
    }
}

class Truck {
    int inTime;
    int weight;

    public Truck(int inTime, int weight) {
        this.inTime = inTime;
        this.weight = weight;
    }
}
