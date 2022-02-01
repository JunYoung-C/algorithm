package inflearn.review.greedy.ex06;

import java.util.Scanner;

public class Main {
    public String solution(int n, int m, int[][] relations, int[] arr) {
        int[] myRoot = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            myRoot[i] = i;
        }
        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];
            unite(a, b, myRoot);
        }

        int fa = find(arr[0], myRoot);
        int fb = find(arr[1], myRoot);
        if (fa == fb) {
            return "YES";
        } else {
            return "NO";
        }
    }

    int find(int me, int[] myRoot) {
        if (myRoot[me] == me) {
            return me;
        } else {
            return myRoot[me] = find(myRoot[me], myRoot);
        }
    }

    void unite(int a, int b, int[] myRoot) {
        int fa = find(a, myRoot);
        int fb = find(b, myRoot);

        if (fa != fb) {
            myRoot[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        int[][] relations = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            relations[i][0] = a;
            relations[i][1] = b;

        }


        int[] arr = {stdIn.nextInt(), stdIn.nextInt()};
        System.out.println(T.solution(n, m, relations, arr));
    }
}
