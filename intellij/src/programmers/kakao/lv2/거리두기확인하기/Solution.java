package programmers.kakao.lv2.거리두기확인하기;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] isVisited;
    boolean keepDistance = true;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            keepDistance = true;

            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (places[i][r].charAt(c) == 'P') {
                        isVisited = new boolean[5][5];
                        isVisited[r][c] = true;
                        checkDistance(r, c, r, c, places[i]);
                    }
                }
            }

            answer[i] = keepDistance ? 1 : 0;
        }
        return answer;
    }

    private void checkDistance(int y, int x, int standardY, int standardX, String[] place) {
        if (!keepDistance) {
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || getDistance(ny, nx, standardY, standardX) > 2 || isVisited[ny][nx]) {
                continue;
            }

            if (place[ny].charAt(nx) == 'P') {
                keepDistance = false;
                return;
            } else if (place[ny].charAt(nx) == 'O') {
                isVisited[ny][nx] = true;
                checkDistance(ny, nx, standardY, standardX, place);
            }
        }
    }

    public int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
