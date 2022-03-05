package programmers.exam.kakao.intern2021.checkdistance;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int[] solution(String[][] places) {
        int height = places[0].length;
        int width = places[0][0].length();
        int len = places.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            boolean isFollowingRules = true;
            ArrayList<Point> personLocations = new ArrayList<>();

            // 사람 위치 찾기
            personLocations = findPeople(places, height, width, i);

            // 맨해튼 거리가 2 이하인 사람들의 거리두기 여부 확인
            isFollowingRules = isFollowingRules(personLocations, places[i]);

            if (isFollowingRules) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private ArrayList<Point> findPeople(String[][] places, int height, int width, int i) {
        ArrayList<Point> personLocations = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (places[i][y].charAt(x) == 'P') {
                    personLocations.add(new Point(x, y));
                }
            }
        }

        return personLocations;
    }

    private boolean isFollowingRules(ArrayList<Point> personLocations, String[] place) {
        int peopleCnt = personLocations.size();

        for (int me = 0; me < peopleCnt; me++) {
            Point MyPoint = personLocations.get(me);
            for (int you = me + 1; you < peopleCnt; you++) {
                Point yourPoint = personLocations.get(you);
                int manDis = getManDistance(MyPoint, yourPoint);
                if (manDis == 2) {
                    int maxX = Math.max(MyPoint.x, yourPoint.x);
                    int minX = Math.min(MyPoint.x, yourPoint.x);
                    int maxY = Math.max(MyPoint.y, yourPoint.y);
                    int minY = Math.min(MyPoint.y, yourPoint.y);
                    int partitionCnt = 0;
                    int totalCnt = 3;
                    // 거리두기 체크

                    if (minY == maxY) {
                        if (place[minY].charAt(minX + 1) == 'X') {
                            partitionCnt++;
                        }
                    } else if (minX == maxX) {
                        if (place[minY + 1].charAt(minX) == 'X') {
                            partitionCnt++;
                        }
                    } else {
                        totalCnt = 4;
                        for (int y = minY; y <= maxY; y++) {
                            for (int x = minX; x <= maxX; x++) {
                                if (place[y].charAt(x) == 'X') {
                                    partitionCnt++;
                                }
                            }
                        }
                    }



                    if (totalCnt -  partitionCnt != 2) {
                        return false;
                    }
                } else if (manDis == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getManDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        for (int i : T.solution(places)) {
            System.out.print(i + " ");
        }
    }
}
