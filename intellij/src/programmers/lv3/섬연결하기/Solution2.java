package programmers.lv3.섬연결하기;

import java.util.*;

class Solution2 {

    private int find(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a], parent);
    }

    private void unite(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if (a != b) {
            parent[b] = a;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) ->  o1[2] - o2[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : costs) {
            int fa = find(e[0], parent);
            int fb = find(e[1], parent);

            if (fa != fb) {
                answer += e[2];
                unite(fa, fb, parent);
            }
        }

        return answer;
    }
}
