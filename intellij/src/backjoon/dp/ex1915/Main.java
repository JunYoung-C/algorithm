package backjoon.dp.ex1915;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int width, int height, int[][] map) {
        int answer = 0;

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                if (map[row][col] == 1 && map[row - 1][col] >= 1 && map[row - 1][col - 1] >= 1 && map[row][col - 1] >= 1) {
                    int min = Math.min(map[row - 1][col], Math.min(map[row - 1][col - 1], map[row][col - 1]));
                    map[row][col] = min + 1;
                }

                answer = Math.max(answer, map[row][col]);
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] map = new int[height + 1][width + 1];

        for (int row = 1; row <= height; row++) {
            String rowString = br.readLine();
            for (int col = 1; col <= width; col++) {
                map[row][col] = rowString.charAt(col - 1) - '0';
            }
        }

//        for (int row = 1; row <= height; row++) {
//            for (int col = 1; col <= width; col++) {
//                System.out.print(map[row][col] + " ");
//            }
//            System.out.println();
//        }

        br.close();
        bw.write(T.solution(width, height, map)+ "");
        bw.flush();
        bw.close();
    }
}
