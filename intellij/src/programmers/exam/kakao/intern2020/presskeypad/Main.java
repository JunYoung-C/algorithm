package programmers.exam.kakao.intern2020.presskeypad;

import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Point leftHandLocation = new Point(3, 0);
        Point rightHandLocation = new Point(3, 2);
        HashMap<Integer, Point> keyPadMap = new HashMap<>();
        initKeyPad(keyPadMap);

        // 1, 4, 7은 무조건 왼손
        // 3, 6, 9는 무조건 오른손
        // 2, 5, 8, 0은 가까운 엄지
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                leftHandLocation = keyPadMap.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                rightHandLocation = keyPadMap.get(number);
            } else {
                int leftHandDis = getDistance(leftHandLocation, keyPadMap.get(number));
                int rightHandDis = getDistance(rightHandLocation, keyPadMap.get(number));

                if (leftHandDis > rightHandDis) {
                    sb.append("R");
                    rightHandLocation = keyPadMap.get(number);
                } else if (leftHandDis < rightHandDis) {
                    sb.append("L");
                    leftHandLocation = keyPadMap.get(number);
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightHandLocation = keyPadMap.get(number);
                    } else {
                        sb.append("L");
                        leftHandLocation = keyPadMap.get(number);
                    }
                }
            }
        }

        return sb.toString();
    }

    private void initKeyPad(HashMap<Integer, Point> keyPadMap) {
        keyPadMap.put(1, new Point(0, 0));
        keyPadMap.put(2, new Point(0, 1));
        keyPadMap.put(3, new Point(0, 2));
        keyPadMap.put(4, new Point(1, 0));
        keyPadMap.put(5, new Point(1, 1));
        keyPadMap.put(6, new Point(1, 2));
        keyPadMap.put(7, new Point(2, 0));
        keyPadMap.put(8, new Point(2, 1));
        keyPadMap.put(9, new Point(2, 2));
        keyPadMap.put(0, new Point(3, 1));
    }


    private int getDistance(Point p1, Point p2) {
        return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";
//
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        String hand = "right";
        System.out.println(T.solution(numbers, hand));
    }
}
