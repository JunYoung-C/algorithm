package backjoon.bruteforce.ex14889;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] numbers) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < (1<<n); i++) {
            if (Integer.bitCount(i) * 2 == n) {
                answer = Math.min(answer, getDifference(i, n, numbers));
            }
        }

        return answer;
    }

    private int getDifference(int teamBit, int n, int[][] numbers) {
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((teamBit & (1<<i)) > 0) {
                teamA.add(i);
            } else {
                teamB.add(i);
            }
        }

        return Math.abs(getSum(numbers, teamA) - getSum(numbers, teamB));
    }

    private static int getSum(int[][] numbers, ArrayList<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                sum += numbers[team.get(i)][team.get(j)] + numbers[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] numbers = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        bw.write(T.solution(n, numbers)+ "");
        bw.flush();
        bw.close();
    }
}
