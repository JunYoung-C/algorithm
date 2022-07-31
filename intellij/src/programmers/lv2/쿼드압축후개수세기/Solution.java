package programmers.lv2.쿼드압축후개수세기;

import java.util.*;

class Solution {
    int[][] points = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public int[] solution(int[][] arr) {
        Area area = dfs(arr, new int[] {0, 0}, arr.length);
        return new int[] {area.zeroCount, area.oneCount};
    }

    // dir : 0 - 좌상, 1 - 우상, 2 - 좌하, 3 - 우하
    private Area dfs(int[][] arr, int[] point, int length) {
        int zeroCount = 0;
        int oneCount = 0;
        if (length == 1) {
            return new Area(arr[0][0] == 0 ? 1 : 0, arr[0][0] == 1 ? 1 : 0);
        } else if (length == 2) {
            for (int[] p : points) {
                if (arr[point[0] + p[0]][point[1] + p[1]] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if (zeroCount == 4) {
                zeroCount = 1;
            } else if (oneCount == 4) {
                oneCount = 1;
            }

            return new Area(zeroCount, oneCount);
        }

        int[][] startPoints = { // 세로, 가로
                {point[0], point[1]},
                {point[0], point[1] + length / 2},
                {point[0] + length / 2, point[1]},
                {point[0] + length / 2, point[1] + length / 2}
        };

        zeroCount = 0;
        oneCount = 0;
        Area area = null;
        for (int[] p : startPoints) {
            area = dfs(arr, p, length / 2);
            zeroCount += area.zeroCount;
            oneCount += area.oneCount;
        }

        if (zeroCount == 4 && oneCount == 0) {
            zeroCount = 1;
        } else if (oneCount == 4 && zeroCount == 0) {
            oneCount = 1;
        }
        return new Area(zeroCount, oneCount);
    }
}

class Area {
    int zeroCount;
    int oneCount;

    public Area(int zeroCount, int oneCount) {
        this.zeroCount = zeroCount;
        this.oneCount = oneCount;
    }
}
