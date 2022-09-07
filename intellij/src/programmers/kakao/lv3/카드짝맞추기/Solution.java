package programmers.kakao.lv3.카드짝맞추기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cursor {
    int x;
    int y;
    int targetIndex;
    boolean isSelected;

    public Cursor(int x, int y, int targetIndex, boolean isSelected) {
        this.x = x;
        this.y = y;
        this.targetIndex = targetIndex;
        this.isSelected = isSelected;
    }

    public int getSelectNumber() {
        return this.isSelected ? 1 : 0;
    }
}

class Solution {
    ArrayList<Integer> cardNumbers = new ArrayList<>();
    boolean[] isUsed;
    int answer = Integer.MAX_VALUE;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board, int r, int c) {
        initCardNumbers(board);
        isUsed = new boolean[cardNumbers.size()];
        permutation(new int[cardNumbers.size()], 0, board, r, c);
        return answer;
    }

    private void permutation(int[] orders, int depth, int[][] board, int startRow, int startCol) {
        if (depth == orders.length) {
//            for (int i : orders) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
            answer = Math.min(answer, getMoveCount(orders, board, startRow, startCol));
            return;
        }

        for (int i = 0; i < cardNumbers.size(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                orders[depth] = cardNumbers.get(i);
                permutation(orders, depth + 1, board, startRow, startCol);
                isUsed[i] = false;
            }
        }
    }

    private int getMoveCount(int[] orders, int[][] board, int startRow, int startCol) {
        int count = 0;
        int index = 0;
        // 목표 인덱스, 선택 여부(0, 1), 4방향, y, x
        boolean[][][][] isVisited = new boolean[cardNumbers.size()][2][4][4];
        boolean[][] isEntered = new boolean[4][4];

        Queue<Cursor> que = new LinkedList<>();
        que.offer(new Cursor(startCol, startRow, index, false));
        isVisited[index][0][startCol][startRow] = true;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Cursor now = que.poll();

                if (now.targetIndex == orders.length) {
                    return count;
                }

                // 방향키
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (isValid(nx, ny) && !isVisited[now.targetIndex][now.getSelectNumber()][ny][nx]) {
                        isVisited[now.targetIndex][now.getSelectNumber()][ny][nx] = true;
                        que.offer(new Cursor(nx, ny, now.targetIndex, now.isSelected));
                    }
                }

                // ctrl + 방향키
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x;
                    int ny = now.y;

                    while (isValid(nx + dx[dir], ny + dy[dir])
                            && isEmpty(board, isEntered, ny + dy[dir], nx + dx[dir])) {
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if ((nx == now.x && ny == now.y) || isVisited[now.targetIndex][now.getSelectNumber()][ny][nx]) {
                        continue;
                    }

                    isVisited[now.targetIndex][now.getSelectNumber()][ny][nx] = true;
                    que.offer(new Cursor(nx, ny, now.targetIndex, now.isSelected));
                }

                // 엔터
                if (board[now.y][now.x] == orders[now.targetIndex] && !isEntered[now.y][now.x]) {
                    if (now.isSelected) {
                        isVisited[now.targetIndex + 1][0][now.y][now.x] = true;
                        que.offer(new Cursor(now.x, now.y, now.targetIndex + 1, false));
                    } else {
                        isVisited[now.targetIndex][1][now.y][now.x] = true;
                        que.offer(new Cursor(now.x, now.y, now.targetIndex, true));
                    }
                    isEntered[now.y][now.x] = true;
                }
            }

            count++;
        }

        return -1;
    }

    private boolean isEmpty(int[][] board, boolean[][] isEntered, int y, int x) {
        return board[y][x] == 0 || isEntered[y][x];
    }


    private boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    private void initCardNumbers(int[][] board) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] != 0 && !cardNumbers.contains(board[row][col])) {
                    cardNumbers.add(board[row][col]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
//        int r = 1;
//        int c = 0;

        int[][] board = {{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}};
        int r = 0;
        int c = 1;
        System.out.println(T.solution(board, r, c));
    }
}
