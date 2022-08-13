package programmers.lv3.아이템줍기;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int[] dx2 = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy2 = {-1, -1, 0, 1, 1, 1, 0, -1};
    boolean[][] board = new boolean[51][51];
    boolean[][] isVisited = new boolean[51][51];
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] rectangles, int characterX, int characterY,
                        int itemX, int itemY) {
        int index = 1;
        for (int[] rectangle : rectangles) {
            // col1, row1, col2, row2
            for (int r = rectangle[1] + 1; r < rectangle[3]; r++) {
                for (int c = rectangle[0] + 1; c < rectangle[2]; c++) {
                    board[r][c] = true;
                }
            }
            index++;
        }

        isVisited[characterY][characterX] = true;
        dfs(characterY, characterX, itemY, itemX, 0, -1);

        for (int r = 10; r >= 0; r--) {
            for (int c = 0; c <= 10; c++) {
                System.out.print((board[r][c] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        return answer;
    }

    private void dfs(int y, int x, int itemY, int itemX, int depth, int currentDir) {
        if (itemX == x && itemY == y) {
            answer = Math.min(answer, depth);
            for (int r = 10; r >= 0; r--) {
                // for (int c = 0; c <= 10; c++) {
                //     System.out.print((isVisited[r][c] ? 1 : 0) + " ");
                // }
                // System.out.println();
            }

            System.out.println();

            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (nx < 0 || nx > 50 || ny < 0 || ny > 50) {
                continue;
            }

            if (!isVisited[ny][nx] && isRound(ny, nx, currentDir, dir)) {
                isVisited[ny][nx] = true;

                dfs(ny, nx, itemY, itemX, depth + 1, dir);

                isVisited[ny][nx] = false;
            }
        }
    }

    private boolean isRound(int y, int x, int currentDir, int nextDir) {
        if (board[y][x] == true) {
            return false;
        }

        if (currentDir != -1) {
            int count = 0;
            int py = y - dy[currentDir];
            int px = x - dx[currentDir];
            if (currentDir == 0 || currentDir == 0) {
                if (px - 1 >= 0) {
                    count += board[py][px - 1] ? 1 : 0;
                }

                if (px + 1 <= 50) {
                    count += board[py][px + 1] ? 1 : 0;
                }
            } else {
                if (py - 1 >= 0) {
                    count += board[py - 1][px] ? 1 : 0;
                }

                if (py + 1 <= 50) {
                    count += board[py + 1][px] ? 1 : 0;
                }
            }

            if (nextDir == 0 || currentDir == 0) {
                if (x - 1 >= 0) {
                    count += board[y][x - 1] ? 1 : 0;
                }

                if (x + 1 <= 50) {
                    count += board[y][x + 1] ? 1 : 0;
                }
            } else {
                if (y - 1 >= 0) {
                    count += board[y - 1][x] ? 1 : 0;
                }

                if (y + 1 <= 50) {
                    count += board[y + 1][x] ? 1 : 0;
                }
            }

            if (count == 0) {
                return false;
            }
        }

        for (int dir = 0; dir < 8; dir++) {
            int ny = y + dy2[dir];
            int nx = x + dx2[dir];

            if (nx < 0 || nx > 50 || ny < 0 || ny > 50) {
                continue;
            }

            if (board[ny][nx] == true) {
                return true;
            }
        }

        return false;
    }
}
