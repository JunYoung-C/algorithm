package programmers.kakao.lv1.키패드누르기;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Point[] points = new Point[] {new Point(3, 1),
                new Point(0, 0), new Point(0, 1), new Point(0, 2),
                new Point(1, 0), new Point(1, 1), new Point(1, 2),
                new Point(2, 0), new Point(2, 1), new Point(2, 2),
        };
        Point left = new Point(3, 0);
        Point right = new Point(3, 2);

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) { // 왼손
                sb.append("L");
                left = points[num];
            } else if (num == 3 || num == 6 || num == 9) { // 오른손
                sb.append("R");
                right = points[num];
            } else {
                // 거리고려, 거리 같으면 hand 고려
                int leftDistance = getDistance(left, points[num]);
                int rightDistance = getDistance(right, points[num]);
                if (leftDistance < rightDistance) {
                    sb.append("L");
                    left = points[num];
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    right = points[num];
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = points[num];
                    } else {
                        sb.append("R");
                        right = points[num];
                    }
                }
            }
        }

        // System.out.println(getDistance(new Point(0, 0), new Point(1, 2)));
        return sb.toString();
    }

    private int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
