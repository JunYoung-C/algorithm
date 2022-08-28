package programmers.kakao.lv3.자물쇠와열쇠;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public boolean solution(int[][] key, int[][] lock) {
        int[][] movedKey;
        // for (int i = 0; i < 4; i++) {
        //     key = movedKey = rotate(key);
        //     for (int j = 0; j < key.length; j++) {
        //         if (isAbleToCombine(movedKey, lock)) {
        //             return true;
        //         }
        //         movedKey = move(movedKey, i);
        //     }
        // }
        key = rotate(key);
        key = rotate(key);
        key = move(key, 2);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3;col++) {
                System.out.print(key[row][col] + " ");
            }
            System.out.println();
        }
        // isAbleToCombine(key, lock);
        return false;
    }

    private boolean isAbleToCombine(int[][] key, int[][] lock) {
        boolean isAbleToCombine = false;
        int lockLen = lock.length;
        int keyLen = key.length;

        for (int keyRow = 0; keyRow <= lockLen - keyLen; keyRow++) {
            for (int keyCol = 0; keyCol <= lockLen - keyLen; keyCol++) {
                if (isCombined(key, lock, keyRow, keyCol)) {
                    return true;
                }
            }
        }

        return isAbleToCombine;
    }

    private boolean isCombined(int[][] key, int[][] lock, int keyRow, int keyCol) {
        int lockLen = lock.length;
        int keyLen = key.length;

        for (int row = 0; row < lockLen; row++) {
            for (int col = 0; col < lockLen; col++) {
                if (row - keyRow >= 0 && row - keyRow < keyLen &&
                        col - keyCol >= 0 && col - keyCol < keyLen) {
                    // if (lock[row][col] + key[row - keyRow][col - keyCol] != 1) {
                    //     return false;
                    // }

                    System.out.print(lock[row][col] + key[row - keyRow][col - keyCol] + " ");
                } else {
//                     if (lock[row][col] != 1) {
//                         return false;
//                     }

                    System.out.print(key[row - keyRow][col - keyCol] + " ");
                }
            }
            System.out.println();
        }

        return true;
    }

    private int[][] move(int[][] board, int dir) {
        int len = board.length;
        int[][] movedBoard = new int[len][len];
        if (dir == 1 || dir == 2) {
            for (int row = dy[dir]; row < len; row++) {
                for (int col = dx[dir]; col < len; col++) {
                    movedBoard[row][col] = board[row - dy[dir]][col - dx[dir]];
                }
            }
        } else {
            for (int row = 0; row < len + dy[dir]; row++) {
                for (int col = 0; col < len + dx[dir]; col++) {
                    movedBoard[row][col] = board[row - dy[dir]][col - dx[dir]];
                }
            }
        }
        return movedBoard;
    }

    private int[][] rotate(int[][] board) {
        int len = board.length;
        int[][] rotatedBoard = new int[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                rotatedBoard[col][len - 1 - row] = board[row][col];
            }
        }

        return rotatedBoard;
    }
}
