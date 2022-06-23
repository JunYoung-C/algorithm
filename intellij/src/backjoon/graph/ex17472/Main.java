package backjoon.graph.ex17472;

import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    static int[][] map;
    int[][] numberingMap;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int width, int height) {
        int answer = 0;
        int nodeCount = initNumberingMap(width, height);

//        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        getWidthEdges(width, height, pQ);
        getHeightEdges(width, height, pQ);

//        for (int row = 0; row < height; row++) {
//            for (int col = 0; col < width; col++) {
//                System.out.print(numberingMap[row][col] + " ");
//            }
//            System.out.println();
//        }

        int[] parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        int connectionCount = 0;

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();
//            System.out.println(e.start + " " + e.end + " " + e.cost);
            if (find(e.start, parent) != find(e.end, parent)) {
                connectionCount++;
                unite(e.start, e.end, parent);
                answer += e.cost;
//                System.out.println(e.start + " " + e.end + " " + e.cost);
            }

            if (connectionCount >= nodeCount - 1) {
                break;
            }
        }

        if (connectionCount == nodeCount - 1) {
            return answer;
        } else {
            return -1;
        }
    }

    private void getHeightEdges(int width, int height, PriorityQueue<Edge> pQ) {
        for (int col = 0; col < width; col++) {
            int start = 0;
            int startIndex = -1;
            int end = 0;
            int endIndex = -1;
            for (int row = 0; row < height; row++) {
                if (numberingMap[row][col] == 0) {
                    continue;
                }

                if (start == 0 || start == numberingMap[row][col]) {
                    start = numberingMap[row][col];
                    startIndex = row;
                } else {
                    end = numberingMap[row][col];
                    endIndex = row;
                    int distance = endIndex - startIndex - 1;

                    if (distance >= 2) {
//                        System.out.println(startIndex + " " + endIndex + ": " + start + " " + end + " " + distance);
                        pQ.offer(new Edge(start, end, distance));
                    }

                    start = end;
                    startIndex = endIndex;
                }
            }

        }
    }

    private void getWidthEdges(int width, int height, PriorityQueue<Edge> pQ) {
        for (int row = 0; row < height; row++) {
            int start = 0;
            int startIndex = -1;
            int end = 0;
            int endIndex = -1;
            for (int col = 0; col < width; col++) {
                if (numberingMap[row][col] == 0) {
                    continue;
                }

                if (start == 0 || start == numberingMap[row][col]) {
                    start = numberingMap[row][col];
                    startIndex = col;
                } else {
                    end = numberingMap[row][col];
                    endIndex = col;
                    int distance = endIndex - startIndex - 1;
                    if (distance >= 2) {
//                        System.out.println(startIndex + " " + endIndex + ": " + start + " " + end + " " + distance);
                        pQ.offer(new Edge(start, end, distance));
                    }

                    start = end;
                    startIndex = endIndex;
                }
            }
        }
    }

    private int find(int a, int[] parent) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a], parent);
    }

    private void unite(int a, int b, int[] parent) {
        int fa = find(a, parent);
        int fb = find(b, parent);
        if (fa != fb) {
            parent[fb] = fa;
        }
    }

    private int initNumberingMap(int width, int height) {
        numberingMap = new int[height][width];
        int islandNumber = 1;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (map[row][col] == 1 && numberingMap[row][col] == 0) {
                    dfs(col, row, islandNumber++, width, height);
                }
            }
        }

        return islandNumber - 1;
    }

    private void dfs(int x, int y, int islandNumber, int width, int height) {
        numberingMap[y][x] = islandNumber;

        for (int direction = 0; direction < 4; direction++) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                continue;
            }

            if (map[ny][nx] == 1 && numberingMap[ny][nx] == 0) {
                dfs(nx, ny, islandNumber, width, height);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        bw.write(T.solution(width, height) + "");
        bw.flush();
        bw.close();
    }
}
