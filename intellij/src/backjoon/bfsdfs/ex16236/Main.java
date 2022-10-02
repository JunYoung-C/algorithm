package backjoon.bfsdfs.ex16236;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isValid(int x, int y, int len) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }
}

public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int answer = 0;

    public int solution(int n, int[][] board, Shark shark) {
        bfs(board, shark);
        return answer;
    }

    private void bfs(int[][] board, Shark startShark) {
        int len = board.length;
        boolean[][] isVisited = new boolean[len][len];
        PriorityQueue<Shark> que = new PriorityQueue<>();
        que.offer(startShark);

        while (!que.isEmpty()) {
            Shark shark = que.poll();

            if (isVisited[shark.location.y][shark.location.x]) {
                continue;
            }

            if (shark.canEat(board[shark.location.y][shark.location.x])) {
                shark.eat();

                answer = shark.moveCount;

                // 초기화
                board[shark.location.y][shark.location.x] = 0;
                isVisited = new boolean[len][len];
                que.clear();
            }

            isVisited[shark.location.y][shark.location.x] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nx = shark.location.x + dx[dir];
                int ny = shark.location.y + dy[dir];

                if (!Point.isValid(nx, ny, len) || isVisited[ny][nx]
                        || (board[ny][nx] > shark.size && board[ny][nx] <= 6)) {
                    continue;
                }

                que.offer(new Shark(new Point(nx, ny), shark.size, shark.eatCount, shark.moveCount + 1));
            }
        }

    }

    class Shark implements Comparable<Shark> {
        Point location;
        int size;
        int eatCount;
        int moveCount;

        public Shark(Point location) {
            this.location = location;
            this.size = 2;
        }

        public Shark(Point location, int size, int eatCount, int moveCount) {
            this.location = location;
            this.size = size;
            this.eatCount = eatCount;
            this.moveCount = moveCount;
        }

        public boolean canEat(int fishSize) {
            return fishSize > 0 && fishSize <= 6 && fishSize < this.size;
        }

        public void eat() {
            this.eatCount++;
            if (this.eatCount == this.size) {
                sizeUp();
            }
        }

        private void sizeUp() {
            this.size++;
            this.eatCount = 0;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.moveCount == o.moveCount) {
                if (this.location.y == o.location.y) {
                    return this.location.x - o.location.x;
                }
                return this.location.y - o.location.y;
            }
            return this.moveCount - o.moveCount;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Shark shark = null;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = T.new Shark(new Point(j, i));
                }
            }
        }

        br.close();
        bw.write(T.solution(n, board, shark)+ "");
        bw.flush();
        bw.close();
    }
}
