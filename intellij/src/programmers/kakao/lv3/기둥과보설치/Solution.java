package programmers.kakao.lv3.기둥과보설치;

import java.util.*;

class Solution {
    boolean[][] existStructure;
    boolean[][] existPillar;
    public int[][] solution(int n, int[][] buildFrames) {
        int[][] answer = {};
        existStructure = new boolean[n + 3][n + 3];
        existPillar = new boolean[n + 3][n + 3];

        for (int[] build : buildFrames) {
            int x = build[0] + 1;
            int y = build[1] + 1;
            int kind = build[2]; // 0:기둥/1:보
            int command = build[3]; // 0:삭제/1:설치

            if (kind == 0) { // 기둥
                buildPillar(x, y, command, n);
            } else { // 보
                buildStructure(x, y, command, n);
            }
        }

        ArrayList<Building> buildings = new ArrayList<>();

        for (int r = 1; r < n + 2; r++) {
            for (int c = 1; c < n + 2; c++) {
                if (existStructure[r][c]) {
                    buildings.add(new Building(c - 1, r - 1, 1));
                }

                if (existPillar[r][c]) {
                    buildings.add(new Building(c - 1, r - 1, 0));
                }
            }
        }

        Collections.sort(buildings);
        int len = buildings.size();
        answer = new int[len][3];
        for (int i = 0; i < len; i++) {
            Building b = buildings.get(i);
            answer[i][0] = b.x;
            answer[i][1] = b.y;
            answer[i][2] = b.kind;
        }

        return answer;
    }

    private void buildStructure(int x, int y, int command, int n) { // command 0:삭제/1:설치


        if (command == 1) { // 설치
            if (isPossibleStructure(x, y)) {
                existStructure[y][x] = true;
            }
        } else {
            removeStructure(x, y);
        }
    }

    private void removeStructure(int x, int y) {
        // 구조물 제거 시
        // 1. 양쪽에 보가 있다면 각각 안정적인지 확인
        // 2. 구조물 위에 기둥이 있다면 제거
        existStructure[y][x] = false;
        boolean canRemove = true;
        if (existStructure[y][x - 1] && !isPossibleStructure(x - 1, y)) {
            canRemove = false;
        }

        if (existStructure[y][x + 1] && !isPossibleStructure(x + 1, y)) {
            canRemove = false;
        }

        if (existPillar[y][x] && !isPossiblePillar(x, y)) {
            canRemove = false;
        }

        if (existPillar[y][x + 1] && !isPossiblePillar(x + 1, y)) {
            canRemove = false;
        }

        if (!canRemove) {
            existStructure[y][x] = true;
        }
    }

    private boolean isPossibleStructure(int x, int y) {
        // 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이
        // 다른 보와 동시에 연결되어 있어야 합니다.
        if (existPillar[y - 1][x] || existPillar[y - 1][x + 1] ||
                (existStructure[y][x - 1] && existStructure[y][x + 1])) {
            return true;
        }
        return false;
    }

    private void buildPillar(int x, int y, int command, int n) {// command 0:삭제/1:설치

        if (command == 1) {
            if (isPossiblePillar(x, y)) {
                existPillar[y][x] = true;
            }
        } else {
            removePillar(x, y);
        }
    }

    private void removePillar(int x, int y) {
        // 기둥 제거 시
        // 1. 제거된 기둥 위에 보가 있다면 보가 안정적인지 확인
        // 2. 제거된 기둥 위에 기둥이 있다면 기둥이 안정적인지 확인
        existPillar[y][x] = false;
        boolean canRemove = true;
        if (existStructure[y + 1][x] && !isPossibleStructure(x, y + 1)) {
            canRemove = false;
        }

        if (existStructure[y + 1][x - 1] && !isPossibleStructure(x - 1, y + 1)) {
            canRemove = false;
        }

        if (existPillar[y + 1][x] && !isPossiblePillar(x, y + 1)) {
            canRemove = false;
        }

        if (!canRemove) {
            existPillar[y][x] = true;
        }
    }

    private boolean isPossiblePillar(int x, int y) {
        // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나,
        // 또는 다른 기둥 위에 있어야 합니다.
        if (y == 1 || existStructure[y][x - 1] || existStructure[y][x] ||
                existPillar[y - 1][x]) {
            return true;
        }
        return false;
    }
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