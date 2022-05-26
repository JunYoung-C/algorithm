package backjoon.dp.ex11409;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Matrix {
    int row;
    int col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    long[][] dp;
    static ArrayList<Matrix> matrixList;
    static int n;

    public long solution() {
        dp = new long[n + 1][n + 1];

        initArr();

        long result = execute(1, n);

        return result;
    }

    private long execute(int start, int end) {
        if (dp[start][end] != Long.MAX_VALUE) {
            return dp[start][end];
        }

        if (start == end) {
            dp[start][end] = 0;
        } else if (end - start == 1) {
            int matrixMul = matrixList.get(start - 1).row * matrixList.get(end - 1).row * matrixList.get(end - 1).col;
            dp[start][end] = matrixMul;
        } else if (end - start > 1) {
            for (int i = 1; i <= n; i++) {
                if (start <= i && i < end) {
                    int matrixMul = matrixList.get(start - 1).row * matrixList.get(i).row * matrixList.get(end - 1).col;
                    dp[start][end] = Math.min(dp[start][end], execute(start, i) + execute(i + 1, end) + matrixMul);
                }
            }
        }

        return dp[start][end];
    }

    private void initArr() {
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        matrixList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            matrixList.add(new Matrix(row, col));
        }

        bw.write(T.solution()+ "");
        bw.flush();
        bw.close();
    }
}
