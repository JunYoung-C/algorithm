package programmers.kakao.lv2.카카오프렌즈컬러링북;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int area = 0;
    boolean[][] isVisited;
    public int[] solution(int height, int width, int[][] picture) {
        int[] answer = new int[2];
        isVisited = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (picture[y][x] == 0 || isVisited[y][x]) {
                    continue;
                }

                numberOfArea++;

                dfs(y, x, width, height, picture[y][x], picture);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                area = 0;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int y, int x, int width, int height, int number, int[][] picture) {
        area++;
        isVisited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                continue;
            }

            if (picture[ny][nx] == number && !isVisited[ny][nx])  {
                dfs(ny, nx, width, height, number, picture);
            }
        }
    }
}
