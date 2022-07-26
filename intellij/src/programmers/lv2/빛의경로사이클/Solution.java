package programmers.lv2.빛의경로사이클;

import java.util.*;

class Solution {
    // 하, 좌, 상, 우
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    boolean[][][] isVisited;
    ArrayList<Integer> cycleCount = new ArrayList<>();

    public int[] solution(String[] grid) {
        int[] answer = {};
        int height = grid.length;
        int width = grid[0].length();
        // 나가는 방향(상, 우, 하, 좌),높이,너비
        isVisited = new boolean[4][height][width];

        for (int dir = 0; dir < 4; dir++) {
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (!isVisited[dir][r][c]) {
                        cycleCount.add(getCycleLength(width, height, grid, dir, r, c));
                    }
                }
            }
        }

        Collections.sort(cycleCount);
        int len = cycleCount.size();
        answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = cycleCount.get(i);
        }

        return answer;
    }

    private int getCycleLength(int width, int height, String[] grid, int dir, int y, int x) {
        int count = 0;

        while (true) {
            if (isVisited[dir][y][x]) {
                break;
            }

            isVisited[dir][y][x] = true;
            count++;

            if (grid[y].charAt(x) == 'R') {
                dir = (dir + 1) % 4;
            } else if (grid[y].charAt(x) == 'L') {
                dir = (dir + 3) % 4;
            }

            y = (y + height + dy[dir]) % height;
            x = (x + width + dx[dir]) % width;

        }

        return count;
    }
}