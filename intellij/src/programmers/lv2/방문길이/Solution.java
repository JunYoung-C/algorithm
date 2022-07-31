package programmers.lv2.방문길이;

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] isVisited = new boolean[4][11][11]; // 방향, y, x
        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('U', 0);
        dirMap.put('R', 1);
        dirMap.put('D', 2);
        dirMap.put('L', 3);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int x = 5, y = 5;
        for (char dir : dirs.toCharArray()) {
            int d = dirMap.get(dir);
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            if (!isVisited[d][y][x]) {
                answer++;
                isVisited[d][y][x] = true;
                isVisited[(d + 2) % 4][ny][nx] = true;
            }

            y = ny;
            x = nx;
        }
        return answer;
    }
}
