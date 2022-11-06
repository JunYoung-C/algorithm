package backjoon.dp.ex10815;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution(int n, int m, int[] cards, int[] targetCards) {
        boolean[] existCards = new boolean[m];
        Arrays.sort(cards);

        for (int i = 0; i < m; i++) {
            if (existCard(n, cards, targetCards[i])) {
                existCards[i] = true;
            }
        }

        for (boolean exist : existCards) {
            if (exist) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

    private boolean existCard(int n, int[] cards, int target) {
        int lt = 0, rt = n - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (cards[mid] == target) {
                return true;
            } else if (cards[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] targetCards = new int[m];
        for (int i = 0; i < m; i++) {
            targetCards[i] = Integer.parseInt(st.nextToken());
        }


        br.close();
        T.solution(n, m, cards, targetCards);
    }
}
