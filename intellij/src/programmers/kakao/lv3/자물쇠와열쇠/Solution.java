package programmers.kakao.lv3.자물쇠와열쇠;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        lock = createLargeLock(lock, key.length);
        for (int i = 0; i < 4; i++) {
            if (isAbleToCombine(key, lock)) {
                return true;
            }
            key = rotate(key);
        }


        return false;
    }

    private boolean isAbleToCombine(int[][] key, int[][] lock) {
        for (int r = 0; r <= lock.length - key.length; r++) {
            for (int c = 0; c <= lock.length - key.length; c++) {
                if (isCombined(r, c, lock, key)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCombined(int r1, int c1, int[][] lock, int[][] key) {
        int keyLen = key.length;
        int len = lock.length;
        boolean isCombined = true;
        for (int r = r1; r < r1 + keyLen; r++) {
            for (int c = c1; c < c1 + keyLen; c++) {
                lock[r][c] += key[r - r1][c - c1];
            }
        }

        for (int r = keyLen - 1; r <= len - keyLen; r++) {
            for (int c = keyLen - 1; c <= len - keyLen; c++) {
                // System.out.println(r + " " + c);
                if (lock[r][c] != 1) {
                    isCombined = false;
                }
            }
        }

        // for (int r = 0; r < len; r++) {
        //     for (int c = 0; c < len; c++) {
        //         System.out.print(lock[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        for (int r = r1; r < r1 + keyLen; r++) {
            for (int c = c1; c < c1 + keyLen; c++) {
                lock[r][c] -= key[r - r1][c - c1];
            }
        }
        return isCombined;
    }

    private int[][] createLargeLock(int[][] lock, int keyLength) {
        int len = keyLength * 2 + lock.length - 2;
        int[][] largeLock = new int[len][len];
        for (int r = 0; r < lock.length; r++) {
            for (int c = 0; c < lock.length; c++) {
                largeLock[r + keyLength - 1][c + keyLength - 1] = lock[r][c];
            }
        }
        return largeLock;
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
