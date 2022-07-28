package programmers.lv2.교점에별만들기;

import java.util.*;

class Solution {
    public String[] solution(int[][] lines) {
        String[] answer = {};
        ArrayList<Point> intersections = new ArrayList<>();
        int len = lines.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                Point point = getLongIntersection(lines[i], lines[j]);
                if (point != null) {
                    intersections.add(point);
                }
            }
        }

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (Point p : intersections) {
            if (p.x > maxX) {
                maxX = p.x;
            }

            if (p.x < minX) {
                minX = p.x;
            }

            if (p.y > maxY) {
                maxY = p.y;
            }

            if (p.y < minY) {
                minY = p.y;
            }

            // System.out.println(p.x + " " + p.y);
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        // System.out.println(maxX + " " + minX + " " + maxY + " " + minY);
        // System.out.println(height + " " + width);

        char[][] points = new char[height][width];
        for (char[] pointArr : points) {
            Arrays.fill(pointArr, '.');
        }

        for (Point p : intersections) {
            points[(int)(p.y - minY)][(int)(p.x - minX)] = '*';
        }

        answer = new String[height];
        for (int row = 0; row < height; row++) {
            answer[row] = new String(points[height - 1 - row]);
        }

        // for (char[] pointArr : points) {
        //     for (char point : pointArr) {
        //         System.out.print(point);
        //     }
        //     System.out.println();
        // }

        return answer;
    }

    private Point getLongIntersection(int[] line1, int[] line2) {
        double a = line1[0];
        double b = line1[1];
        double c = line2[0];
        double d = line2[1];
        double e = line1[2];
        double f = line2[2];

        if (a * d == b * c) {
            return null;
        }

        double x = (b * f - e * d) / (a * d - b * c);
        double y = (e * c - a * f) / (a * d - b * c);

        if (x != Math.floor(x) || y != Math.floor(y)) {
            return null;
        }

        return new Point((long)x, (long)y);
    }
}

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
