package programmers.kakao.lv3.자물쇠와열쇠;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        lock = getBigLock(key.length, lock);

        for (int i = 0; i < 4; i++) {
            if (isPossible(key, lock)) {
                return true;
            }
            System.out.println();
            rotate(key);
        }

        // for (int r = 0; r < lock.length; r++) {
        //     for (int c = 0; c < lock.length; c++) {
        //         System.out.print(lock[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        return false;
    }

    private boolean isPossible(int[][] key, int[][] lock) {
        int lockLen = lock.length, keyLen = key.length;
        for (int r = 0; r <= lockLen - keyLen; r++) {
            for (int c = 0; c <= lockLen - keyLen; c++) {
                if (isSame(key, lock, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSame(int[][] key, int[][] lock, int sr, int sc) {
        boolean isSame = true;
        int lockLen = lock.length, keyLen = key.length;
        for (int r = 0; r < keyLen; r++) {
            for (int c = 0; c < keyLen; c++) {
                lock[r + sr][c + sc] += key[r][c];
            }
        }

        for (int r = keyLen - 1; r <= lockLen - keyLen; r++) {
            for (int c = keyLen - 1; c <= lockLen - keyLen; c++) {
                if (lock[r][c] != 1) {
                    isSame = false;
                }
                // System.out.print(lock[r][c] + " ");
            }
            // System.out.println();
        }
        // System.out.println();

        for (int r = 0; r < keyLen; r++) {
            for (int c = 0; c < keyLen; c++) {
                lock[r + sr][c + sc] -= key[r][c];
            }
        }

        return isSame;
    }

    private int[][] getBigLock(int keyLen, int[][] lock) {
        int lockLen = lock.length;
        int len = lockLen + 2 * keyLen - 2;
        int[][] bigLock = new int[len][len];

        for (int r = 0; r < lockLen; r++) {
            for (int c = 0; c < lockLen; c++) {
                bigLock[r + keyLen - 1][c + keyLen - 1] = lock[r][c];
            }
        }

        return bigLock;
    }

    private void rotate(int[][] board) {
        int len = board.length;
        int[][] tmp = new int[len][len];

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                tmp[c][len - 1 - r] = board[r][c];
            }
        }

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                board[r][c] = tmp[r][c];
            }
        }
    }
}
