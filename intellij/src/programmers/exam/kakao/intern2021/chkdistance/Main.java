package programmers.exam.kakao.intern2021.chkdistance;


import java.util.Scanner;

class Solution {
    boolean keepDistance;
    int PLACE_COUNT = 5;
    int WIDTH = 5;
    int HEIGHT = 5;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] isVisited;

    public int[] solution(String[][] places) {
        int[] answer = new int[PLACE_COUNT];
        for (int i = 0; i < PLACE_COUNT; i++) {
            checkDistance(places[i]);
            answer[i] = keepDistance ? 1 : 0;
        }
        return answer;
    }

    private void checkDistance(String[] place) {
        keepDistance = true;
        isVisited = new boolean[HEIGHT][WIDTH];

        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                if (place[r].charAt(c) == 'P') {
                    dfs(place, new Point(r, c), new Point(r, c));
                }
            }
        }
    }

    private void dfs(String[] place, Point checkPoint, Point currentPoint) {
        if (!keepDistance) {
            return;
        }
        isVisited[currentPoint.row][currentPoint.col] = true;

        for (int direction = 0; direction < 4; direction++) {
            // 맨해튼 거리 2이하에 사람이 있는 경우 확인
            // 단 파티션으로 막혀있으면 허용
            int nx = currentPoint.col + dx[direction];
            int ny = currentPoint.row + dy[direction];

            if (nx < 0 || nx >= WIDTH || ny < 0 || ny >= HEIGHT) {
                continue;
            }

            if (getManDistance(checkPoint, new Point(ny, nx)) <= 2 && !isVisited[ny][nx]) {

                // 파티션이면 dfs x
                // 빈 테이블이면 dfs o
                // 사람이면 keepDistance = false로 하고 종료
                if (place[ny].charAt(nx) == 'O') { // 빈테이블인 경우
                    dfs(place, checkPoint, new Point(ny, nx));
                } else if (place[ny].charAt(nx) == 'P') {
                    keepDistance = false;
                    return;
                }
            }
        }

    }

    private int getManDistance(Point point1, Point point2) {
        return Math.abs(point1.row - point2.row) + Math.abs(point1.col - point2.col);
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

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        for (int i : T.solution(places)) {
            System.out.print(i + " ");
        }
    }
}
