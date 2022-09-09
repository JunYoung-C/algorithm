package programmers.kakao.lv3.사라지는발판;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    final int A_NUMBER = 1;
    final int B_NUMBER = -1;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Turn turn = dfs(A_NUMBER, board,
                new Player(aloc[1], aloc[0]),
                new Player(bloc[1], bloc[0]));
        return turn.count;
    }

    // 플래이어는 1 또는 -1
    private Turn dfs(int playerNumber, int[][] board, Player A, Player B) {
        // 이기면 min 값을 반환
        // 지면 max 값을 반환
        Player currentPlayer = (playerNumber == A_NUMBER) ? A : B;
        if (board[currentPlayer.y][currentPlayer.x] == 0) {
            return new Turn(0, -playerNumber);
        }

        int count = -1;
        boolean canWin = false;

        for (int dir = 0; dir < 4; dir++) {
            int nx = currentPlayer.x + dx[dir];
            int ny = currentPlayer.y + dy[dir];

            if (nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length
                    || board[ny][nx] != 1) {
                continue;
            }

            Turn turn;
            board[currentPlayer.y][currentPlayer.x] = 0;
            if (playerNumber == A_NUMBER) { // A
                turn = dfs(-playerNumber, board, new Player(nx, ny), B);
            } else {
                turn = dfs(-playerNumber, board, A, new Player(nx, ny));
            }
            board[currentPlayer.y][currentPlayer.x] = 1;

            if (turn.winner == playerNumber) {
                // currentPlayer가 winner인 Turn의 최소 count가 필요
                if (canWin) {
                    count = Math.min(count, turn.count);
                } else {
                    canWin = true;
                    count = turn.count;
                }
            } else {
                // currentPlayer가 winner가 아닌 Turn의 최대 count가 필요
                if (!canWin) {
                    count = Math.max(count, turn.count);
                }
            }
        }

        return new Turn(count + 1, canWin ? playerNumber : -playerNumber);
    }
}

class Player {
    int x;
    int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Turn {
    int count;
    int winner;

    public Turn(int count, int winner) {
        this.count = count;
        this.winner = winner;
    }
}
