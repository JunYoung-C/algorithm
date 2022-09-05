package programmers.kakao.lv3.카드짝맞추기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int deleteBit;
    int selectBit; // 0은 아무것도 선택하지 않은 상태
    int selectNumber;

    public Point(int x, int y, int deleteBit, int selectBit) {
        this.x = x;
        this.y = y;
        this.deleteBit = deleteBit;
        this.selectBit = selectBit;
    }

    public Point(int x, int y, int deleteBit, int selectBit, int selectNumber) {
        this.x = x;
        this.y = y;
        this.deleteBit = deleteBit;
        this.selectBit = selectBit;
        this.selectNumber = selectNumber;
    }
}
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        int len = board.length;
        boolean[][][][] isVisited = new boolean[1 << 6][1 << 16][4][4]; // 삭제 관련 비트, 좌표 선택 관련 비트, y, x
        Queue<Point> que = new LinkedList<>();
        int deleteBit = getDeleteBit(board);
//        System.out.println(deleteBit + " " + Integer.toBinaryString(deleteBit));
        int L = 0;
        que.offer(new Point(c, r, deleteBit, 0));
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point now = que.poll();
                System.out.println(now.x + " " + now.y + " " + now.deleteBit + " " + now.selectBit + " " + now.selectNumber);
                if (now.deleteBit == 0) {
                    return L;
                }

                if (isVisited[now.deleteBit][now.selectBit][now.y][now.x]) {
                    continue;
                }
                isVisited[now.deleteBit][now.selectBit][now.y][now.x] = true;

                // 방향키
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];
                    if (isValid(nx, ny) && !isVisited[now.deleteBit][now.selectBit][ny][nx]) {
                        que.offer(new Point(nx, ny, now.deleteBit, now.selectBit, now.selectNumber));
                    }
                }

                // ctrl + 방향키
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];
                    while (isValid(nx, ny)) {
                        if ((now.deleteBit & (1 << (board[ny][nx] - 1))) != 0) {
                            break;
                        }
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if (isValid(nx, ny) && !isVisited[now.deleteBit][now.selectBit][ny][nx]) {
                        que.offer(new Point(nx, ny, now.deleteBit, now.selectBit, now.selectNumber));
                    }
                }

                // 엔터
                int pointBit = getPointBit(now.x, now.y);
                int boardValueBit = 1 << (board[now.y][now.x] - 1);

                if ((now.deleteBit & boardValueBit) > 0 && now.selectBit != pointBit) {
                    if (now.selectBit == 0 && !isVisited[now.deleteBit][pointBit][now.y][now.x]) {
                        que.offer(new Point(now.x, now.y, now.deleteBit, pointBit, board[now.y][now.x]));
                    } else if (now.selectBit != 0 && now.selectNumber == board[now.y][now.x]
                            && !isVisited[now.deleteBit ^ boardValueBit][0][now.y][now.x]) {
                        que.offer(new Point(now.x, now.y, now.deleteBit ^ boardValueBit, 0, 0));
                    }
                }

//                System.out.println(boardValueBit + " " + now.deleteBit);
//                if ((now.deleteBit & boardValueBit) > 0) {
////                    System.out.println(now.deleteBit + " " + boardValueBit + " " + (now.deleteBit ^ boardValueBit));
//                    if (now.selectBit == 0 && !isVisited[now.deleteBit][board[now.y][now.x]][now.y][now.x]) {
//                        que.offer(new Point(now.x, now.y, now.deleteBit, board[now.y][now.x]));
//                    } else if (now.selectBit != 0 && now.selectBit == board[now.y][now.x]
//                            && !isVisited[now.deleteBit ^ boardValueBit][0][now.y][now.x]) {
//                        que.offer(new Point(now.x, now.y, now.deleteBit ^ boardValueBit, 0));
//                    }
//                }
            }

            System.out.println();
            L++;
        }

        return answer;
    }


    private int getPointBit(int x, int y) { // 1이상 2^16 - 1이하
        return 1 << (4 * y + x);
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    private static int getDeleteBit(int[][] board) {
        int len = board.length;
        int deleteBit = 0;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                deleteBit |= 1 << (board[r][c] - 1);
            }
        }
        return deleteBit;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
//        int r = 1;
//        int c = 0;
        
        int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        int r = 0;
        int c = 1;
        System.out.println(T.solution(board, r, c));
    }
}
