package backjoon.numbertheory.ex1850;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public String solution(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        long oneCount = gcd(max, min);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oneCount; i++) {
            sb.append(1);
        }
        return sb.toString();
    }

    private long gcd(long a, long b) {
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

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        br.close();
        bw.write(T.solution(a, b)+ "");
        bw.flush();
        bw.close();
    }
}
