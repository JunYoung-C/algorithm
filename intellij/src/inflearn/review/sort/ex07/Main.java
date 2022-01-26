package inflearn.review.sort.ex07;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (o.x == this.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

public class Main {
    public Point[] solution(int n, Point[] points) {
        Arrays.sort(points);
        return points;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(stdIn.nextInt(), stdIn.nextInt());
        }

        for (Point p : T.solution(n, points)) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
