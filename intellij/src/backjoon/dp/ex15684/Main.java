package backjoon.dp.ex15684;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int answer = 4;
    boolean[][] existLadder;

    public int solution(int width, int height, int lineCount, ArrayList<LineInfo> lineInfoList) {
        initExistLadder(width, height, lineInfoList);

//        for (int i = 0; i <= height; i++) {
//            for (int j = 0; j <= width; j++) {
//                System.out.print((existLadder[i][j] ? 1 : 0) + " ");
//            }
//            System.out.println();
//        }

        dfs(0, 1, 0, width, height);

        if (answer == 4) {
            return -1;
        } else {
            return answer;
        }
    }

    private void dfs(int lastX, int lastY, int addedLineCount, int width, int height) {
        // i번이 i인지 체크
//        for (int i = 1; i <= height; i++) {
//            for (int j = 1; j <= width; j++) {
//                System.out.print((existLadder[i][j] ? 1 : 0) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(addedLineCount);
        if (canBeAnswer(width, height)) {
            answer = Math.min(answer, addedLineCount);
        }

        if (addedLineCount >= 3) {
            return;
        }

        for (int y = lastY; y <= height; y++) {
            for (int x = (y == lastY ? lastX + 1 : 1); x <= width; x++) {
                if (canInstall(y, x, width)) {
                    existLadder[y][x] = true;
                    dfs(x, y, addedLineCount + 1, width, height);
                    existLadder[y][x] = false;
                }
            }
        }
    }

    private boolean canBeAnswer(int width, int height) {
        for (int x = 1; x <= width; x++) {
            int index = x;

            for (int y = 1; y <= height; y++) {
                if (existLadder[y][index]) {
                    index++;
                } else if (existLadder[y][index - 1]) {
                    index--;
                }
            }

            if (x != index) {
                return false;
            }
//            System.out.print(x + " ");
        }

        return true;
    }

    private boolean canInstall(int y, int x, int width) {
        if (x != width && !existLadder[y][x] && !existLadder[y][x - 1] && !existLadder[y][x + 1]) {
            return true;
        }
        return false;
    }

    private void initExistLadder(int width, int height, ArrayList<LineInfo> lineInfoList) {
        existLadder = new boolean[height + 1][width + 1];
        for (LineInfo line : lineInfoList) {
            existLadder[line.row][line.col] = true;
        }
    }

    static class LineInfo {
        int row;
        int col;

        public LineInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        ArrayList<LineInfo> lineInfoList = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            lineInfoList.add(new LineInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        br.close();
        bw.write(T.solution(width, height, lineCount, lineInfoList)+ "");
        bw.flush();
        bw.close();
    }
}
