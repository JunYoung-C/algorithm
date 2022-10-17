package backjoon.dp.ex12865;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int limitWeight, ArrayList<Thing> things) {
        int[] dp = new int[limitWeight + 1];

        for (Thing thing : things) {
            for (int i = limitWeight; i >= thing.weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - thing.weight] + thing.value);
            }

//            for (int i : dp)  {
//                System.out.print(i + " ");
//            }
//            System.out.println();
        }

        return dp[limitWeight];
    }

    class Thing {
        int weight;
        int value;

        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int limitWeight = Integer.parseInt(st.nextToken());

        ArrayList<Thing> things = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            things.add(T.new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        br.close();
        bw.write(T.solution(n, limitWeight, things)+ "");
        bw.flush();
        bw.close();
    }
}
