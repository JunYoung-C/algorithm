package programmers.kakao.lv2.프렌즈4블록;

import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int height, int width, String[] board) {
        char[][] charBoard = new char[height][width];
        setCharBoard(charBoard, board, width, height);
        while (true) {
            ArrayList<Point> removePoints = createRemovePoints(width, height, charBoard);
            // System.out.println(removePoints.size());
            if (removePoints.size() == 0) {
                break;
            }

            for (Point p : removePoints) {
                removeSquare(charBoard, p.y, p.x);
            }

            char[][] changedBoard = new char[height][width];
            setChangedBoard(width, height, changedBoard, charBoard);
            charBoard = changedBoard;
        }


        // for (int r = 0; r < height; r++) {
        //     for (int c = 0; c < width; c++) {
        //         System.out.print(charBoard[r][c] + "   ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }

    private void setChangedBoard(int width, int height, char[][] changedBoard , char[][] charBoard) {
        for (int c = 0; c < width; c++) {
            int r2 = height - 1;
            for (int r = height - 1; r >= 0; r--) {
                if (charBoard[r][c] == ' ') {
                    continue;
                }

                changedBoard[r2--][c] = charBoard[r][c];

            }
        }
    }

    private void removeSquare(char[][] charBoard, int r, int c) {
        if (charBoard[r][c] != ' ') {
            charBoard[r][c] = ' ';
            answer++;
        }

        if (charBoard[r - 1][c] != ' ') {
            charBoard[r - 1][c] = ' ';
            answer++;
        }

        if (charBoard[r][c - 1] != ' ') {
            charBoard[r][c - 1] = ' ';
            answer++;
        }

        if (charBoard[r - 1][c - 1] != ' ') {
            charBoard[r - 1][c - 1] = ' ';
            answer++;
        }
    }

    private ArrayList<Point> createRemovePoints(int width, int height, char[][] charBoard) {
        ArrayList<Point> removePoints = new ArrayList<>();
        for (int r = 1; r < height; r++) {
            for (int c = 1; c < width; c++) {
                if (charBoard[r][c] < 'A' || charBoard[r][c] > 'Z') {
                    continue;
                }
                if (charBoard[r][c] == charBoard[r - 1][c] &&
                        charBoard[r][c] == charBoard[r][c - 1] &&
                        charBoard[r][c] == charBoard[r - 1][c - 1]) {
                    removePoints.add(new Point(c, r));
                    // System.out.println(r + " " + c);
                }
            }
        }

        return removePoints;
    }

    private void setCharBoard(char[][] charBoard, String[] board, int width, int height) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                charBoard[r][c] = board[r].charAt(c);
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
