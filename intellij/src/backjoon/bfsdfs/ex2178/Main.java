package backjoon.bfsdfs.ex2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int width, int height, String[] map) {
        return bfs(width, height, map);
    }

    private int bfs(int width, int height, String[] map) {
        Queue<Point> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[height][width];
        que.offer(new Point(0, 0));
        isVisited[0][0] = true;
        int depth = 0;

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Point now = que.poll();

                for (int direction = 0; direction < 4; direction++) {
                    int ny = now.y + dy[direction];
                    int nx = now.x + dx[direction];

                    if (ny == height - 1 && nx == width) {
                        return depth + 1;
                    }

                    if (ny < 0 || ny >= height || nx < 0 || nx >= width || isVisited[ny][nx] || map[ny].charAt(nx) == '0') {
                        continue;
                    }

                    isVisited[ny][nx] = true;
                    que.offer(new Point(nx, ny));
                }
            }


            depth++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        String[] map = new String[height];

        for (int i = 0; i < height; i++) {
            map[i] = br.readLine();
        }

        br.close();
        bw.write(T.solution(width, height, map)+ "");
        bw.flush();
        bw.close();
    }
}
