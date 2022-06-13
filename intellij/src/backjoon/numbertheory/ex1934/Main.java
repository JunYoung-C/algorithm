package backjoon.numbertheory.ex1934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int a, int b) {
        int gcd = gcd(Math.max(a, b), Math.min(a, b));

        return a * b / gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(T.solution(a, b)+ "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
