package backjoon.combination.ex1256;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[][] combination = new long[201][201];

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= 200; i++) {
            combination[i][0] = 1;
            combination[i][1] = i;
            combination[i][i] = 1;
        }

        for (int n = 3; n <= 200; n++) {
            for (int r = 2; r < n; r++) {
                combination[n][r] = combination[n - 1][r - 1] + combination[n - 1][r];

                if (combination[n][r] > 1000000000) {
                    combination[n][r] = 1000000001;
                }
            }
        }

        int a = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (k > combination[a + z][a]) {
            sb.append(-1);
        } else {
            while(!(a == 0 && z == 0)) {
                if (k <= combination[a + z - 1][z]) {
                    sb.append("a");
                    a--;
                } else {
                    sb.append("z");
                    k -= combination[a + z - 1][z];
                    z--;
                }
            }
        }


        br.close();
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}
