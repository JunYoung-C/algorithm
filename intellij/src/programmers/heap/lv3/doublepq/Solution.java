package programmers.heap.lv3.doublepq;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
        PriorityQueue<Integer> descPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String operationStr : operations) {
            String[] operationArr = operationStr.split(" ");
            String oper = operationArr[0];
            int num = Integer.parseInt(operationArr[1]);

            if (oper.equals("I")) { // 삽입
                ascPQ.offer(num);
                descPQ.offer(num);

            } else { //삭제
                if (num == 1 && !descPQ.isEmpty()) { // 최댓값 삭제
                    ascPQ.remove(descPQ.poll());
                } else if (num == -1 && !ascPQ.isEmpty()) { // 최솟값 삭제
                    descPQ.remove(ascPQ.poll());
                }
            }
        }

        if (!descPQ.isEmpty()) {
            answer[0] = descPQ.poll();
        }
        if (!ascPQ.isEmpty()) {
            answer[1] = ascPQ.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String[] operations;

        operations = new String[]{"I 16", "D 1"};
//        operations = new String[]{"I 7", "I 5", "I -5", "D -1"};
        for (int i : T.solution(operations)) {
            System.out.print(i + " ");
        }
    }
}
