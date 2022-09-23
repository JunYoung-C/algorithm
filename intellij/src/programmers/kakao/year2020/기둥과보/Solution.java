package programmers.kakao.year2020.기둥과보;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    boolean[][] existPillar;
    boolean[][] existStructure;

    public int[][] solution(int n, int[][] build_frames) {
        int[][] answer = {};
        existPillar = new boolean[n + 1][n + 1];
        existStructure = new boolean[n + 1][n + 1];

        for (int[] f : build_frames) {
            BuildFrame frame = new BuildFrame(f);

            if (frame.isInstallation()) {
                if (frame.isPillar()) {
                    frame.installPillar();
                } else if (frame.isStructure()) {
                    frame.installStructure();
                }
            } else {
                if (frame.isPillar()) {
                    frame.deletePillar();
                } else if (frame.isStructure()) {
                    frame.deleteStructure();
                }
            }
        }

        ArrayList<Building> buildings = new ArrayList<>();
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                if (existPillar[r][c]) {
                    buildings.add(new Building(c, r, 0));
                }
                if (existStructure[r][c]) {
                    buildings.add(new Building(c, r, 1));
                }
            }
        }

        Collections.sort(buildings);

        int len = buildings.size();
        answer = new int[len][3];
        for (int i = 0; i < len; i++) {
            answer[i][0] = buildings.get(i).x;
            answer[i][1] = buildings.get(i).y;
            answer[i][2] = buildings.get(i).kind;
        }
        for (int r = n; r >= 0; r--) {
            for (int c = 0; c <= n; c++) {
                if (existPillar[r][c]) {
                    System.out.print(1 + " ");
                } else if (existStructure[r][c]) {
                    System.out.print(2 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        int n = 5;
//        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1},
//                {4, 2, 1, 1}, {3, 2, 1, 1}};

        int n = 5;
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1},
                {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        System.out.println(T.solution(n, build_frame));
    }

    class Building implements Comparable<Building> {
        int x;
        int y;
        int kind; // 0 : 기둥, 1 : 보

        public Building(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }

        @Override
        public int compareTo(Building o) {
            if (this.x == o.x) {
                if (this.y == o.y) {
                    return this.kind - o.kind;
                }

                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }

    class BuildFrame {
        int x;
        int y;
        int kind;
        int command;

        public BuildFrame(int x, int y, int kind, int command) {
            this.x = x;
            this.y = y;
            this.kind = kind;
            this.command = command;
        }

        public BuildFrame(int[] frame) {
            this(frame[0], frame[1], frame[2], frame[3]);
        }

        public boolean isPillar() {
            return kind == 0;
        }

        public boolean isStructure() {
            return kind == 1;
        }

        public boolean isInstallation() {
            return command == 1;
        }

        public boolean isDeletion() {
            return command == 0;
        }

        public void installPillar() {
            if (isPossiblePillar(x, y)) {
                existPillar[y][x] = true;
            }
        }

        private boolean isPossiblePillar(int x, int y) {
            return y == 0 // 바닥 위
                    || existPillar[y - 1][x] // 기둥 위
                    || (x - 1 >= 0 && existStructure[y][x - 1]) // 보의 한쪽 끝부분 위
                    || existStructure[y][x]; // 보의 한쪽 끝부분 위
        }

        public void installStructure() {
            if (isPossibleStructure(x, y)) {
                existStructure[y][x] = true;
            }
        }

        private boolean isPossibleStructure(int x, int y) {
            int len = existPillar.length;
            if (y == 0) {
                return false;
            }

            return existPillar[y - 1][x] // 한쪽 끝 부분이 기둥 위
                    || (x + 1 < len && existPillar[y - 1][x + 1]) // 한쪽 끝 부분이 기둥 위
                    || ((x - 1 >= 0 && existStructure[y][x - 1]) && (x + 1 < len && existStructure[y][x + 1])); // 다른 보와 연결
        }

        public void deletePillar() {
            int len = existPillar.length;

            existPillar[y][x] = false;

            if (y == len - 1) { // 천장인 경우
                return;
            }

            if ((x - 1 >= 0 && existStructure[y + 1][x - 1] && !isPossibleStructure(x - 1, y + 1))
                    || (existStructure[y + 1][x] && !isPossibleStructure(x, y + 1))
                    || (existPillar[y + 1][x] && !isPossiblePillar(x, y + 1))) {
                existPillar[y][x] = true;
            }

        }

        public void deleteStructure() {
            int len = existPillar.length;

            existStructure[y][x] = false;

            if ((x - 1 >= 0 && existStructure[y][x - 1] && !isPossibleStructure(x - 1, y))
                    || (x + 1 < len && existStructure[y][x + 1] && !isPossibleStructure(x + 1, y))
                    || (existPillar[y][x] && !isPossiblePillar(x, y))
                    || (x + 1 < len && existPillar[y][x + 1]) && !isPossiblePillar(x + 1, y)) {
                existStructure[y][x] = true;
            }
        }
    }
}
